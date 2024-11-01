package com.example.even.controller;

import com.example.even.dto.MemberRequestDto;
import com.example.even.service.MemberService;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    //로그인 페이지로 이동
    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    /**
     * 로그인
     * TODO: 응답 및 예외 공통화,
     *
     * @param loginDto
     * @return 토큰 대용인 memberId
     */
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody MemberRequestDto.Login loginDto) {
        Map<String, String> map = new HashMap<>();
        try {
            Long memberId = memberService.login(loginDto);
            map.put("status:", "success");
            map.put("memberId:", String.valueOf(memberId));
        } catch (Exception e) {
            map.put("status:", "error - " + e.getMessage());
        }

        return map;

//        Long memberId = member.getMemberId();
//        String password = member.getPassword();
//
//        try {
//            Member logined = memberService.login(memberId, password);
//            session.setAttribute("loggedInMember", logined);  // 로그인된 사용자 세션에 저장
//            return "redirect:/home";  // 로그인 성공 후 홈 페이지로 리다이렉트
//        } catch (IllegalStateException e) {
//            model.addAttribute("errorMessage", e.getMessage());
//            return "login";  // 오류가 있으면 로그인 페이지로 돌아갑니다.
//        }
    }

    //회원가입 페이지로 이동
    @GetMapping("/join")
    public String join() {
        return "join";
    }

    /**
     * 회원등록
     *
     * @param joinDto
     * @return 토큰 대용인 memberId
     */
    @PostMapping(value = "/join")
    public Map<String, Object> createMember(@RequestBody MemberRequestDto.Join joinDto) {
        Map<String, Object> map = new HashMap<>();
        try {
            Long memberId = memberService.join(joinDto);
            map.put("status:", "success");
            map.put("memberId:", String.valueOf(memberId));
        } catch (Exception e) {
            map.put("status:", "error - " + e.getMessage());
        }

        return map;
//        try {
//            memberService.join(member);
//            return "redirect:/login";  // 회원가입 성공 후 로그인 페이지로 리다이렉트
//        } catch (IllegalStateException e) {
//            model.addAttribute("errorMessage", e.getMessage());
//            return "register";  // 오류가 있으면 회원가입 페이지로 돌아갑니다.
//        }
    }

    // 로그아웃
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();  // 세션 무효화
        return "redirect:/login";  // 로그아웃 후 로그인 페이지로 리다이렉트
    }
}
