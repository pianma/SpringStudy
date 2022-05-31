package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.apache.el.util.ReflectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    /*이런 식으로 쓸 수 있지만 Spring이 관리하게 되면 다 SpringContainer에 등록하게 되고 SpringContainer에서 받아서 쓰도록 바꿔야함
      왜냐하면 new로 만들면 MemberController말고 다른 여러 컨트롤러들이 MemberService를 가져다 쓸 수 있게되는 문제가 발생함
       private final MemberService memberService = new MemberService();
    */

    private  final MemberService memberService;

    //생성자에 Autowired라고 쓰면 MemberService를 Spring이 SpringContainer에 있는 MemberService를 가져다가 연결시킴
    //controller와 service를 연결시킴
    //이게 바로 의존관계 주입(Dependency Injection)이다.
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return  "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
