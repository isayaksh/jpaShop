package jpabook.jpashop.api;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;
    
    /** 회원 등록 API **/

    /** Member Entity 를 직접 맵핑하면 문제가 발생한다. **/
    @PostMapping("/api/v1/members")
    public CreateMemberResponse saveMemberV1(@RequestBody @Valid Member member){
        Long id = memberService.join(member);
        return new CreateMemberResponse(id);
    }

    /** API 요청 스펙에 맞추어 별도의 DTO 를 파라미터로 받는 것이 좋다. **/
    @PostMapping("/api/v2/members")
    public CreateMemberResponse saveMemberV2(@RequestBody @Valid CreateMemberRequest request){
        Member member = Member.createMember(request.getName(), null);
        Long id = memberService.join(member);
        return new CreateMemberResponse(id);
    }

    @Data
    @Getter
    static class CreateMemberRequest {
        @NotEmpty
        private String name;
    }

    @Data
    @AllArgsConstructor
    static class CreateMemberResponse{
        private Long id;
    }
    
    /** 회원 수정 API **/

    @PutMapping("/api/v2/members/{id}")
    public UpdateMemberResponse updateMemberV1(@PathVariable("id") Long id, @RequestBody @Valid UpdateMemberRequest request){
        memberService.update(id, request.getName());
        Member member = memberService.findOne(id);
        return new UpdateMemberResponse(member.getId(), member.getName());
    }

    @Data
    @AllArgsConstructor
    static class UpdateMemberResponse {
        private Long id;
        private String name;
    }

    @Data
    @Getter
    static class UpdateMemberRequest{
        private String name;
    }

    /** 회원 조회 API **/

    @GetMapping("/api/v1/members")
    public List<Member> findMemberV1(){
        return memberService.findAll();
    }

    @GetMapping("/api/v2/members")
    public Result findMemberV2(){
        List<MemberDto> collect = memberService.findAll().stream()
                .map(m -> new MemberDto(m.getName()))
                .collect(Collectors.toList());
        return new Result(collect.size(),collect);
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private int size;
        private T data;
    }

    @Data
    @AllArgsConstructor
    static class MemberDto {
        private String name;
    }
}
