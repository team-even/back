package com.example.even.controller;

//import ch.qos.logback.core.model.Model;
import com.example.even.domain.Member;
import com.example.even.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    //로그인 페이지로 이동
    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    //로그인
    @PostMapping("/login")
    public String login(@ModelAttribute Member member, Model model, HttpSession session) {
        Long memberId = member.getMemberId();
        String password = member.getPassword();

        try {
            Member logined = memberService.login(memberId, password);
            session.setAttribute("loggedInMember", logined);  // 로그인된 사용자 세션에 저장
            return "redirect:/home";  // 로그인 성공 후 홈 페이지로 리다이렉트
        } catch (IllegalStateException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "login";  // 오류가 있으면 로그인 페이지로 돌아갑니다.
        }
    }

    //회원가입 페이지로 이동
    @GetMapping("/join")
    public String join() {
        return "join";
    }

    //회원등록
    @PostMapping(value ="/join")
    public String createMember(@ModelAttribute Member member, Model model) {
        try {
            memberService.join(member);
            return "redirect:/login";  // 회원가입 성공 후 로그인 페이지로 리다이렉트
        } catch (IllegalStateException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "register";  // 오류가 있으면 회원가입 페이지로 돌아갑니다.
        }
    }

    // 로그아웃
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();  // 세션 무효화
        return "redirect:/login";  // 로그아웃 후 로그인 페이지로 리다이렉트
    }
}
