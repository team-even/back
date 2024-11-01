package com.example.even.controller;

import com.example.even.service.MemberService;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class AchievementController {
    private final MemberService memberService;

    @GetMapping("/achievement")
    public Map<String, Object> achievement(Long memberId) {
//        //사용자
//        Member loggedInMember = (Member) session.getAttribute("loggedInMember");
//        if (loggedInMember == null) {
//            return "redirect:/login";  // 로그인이 안 되어 있으면 로그인 페이지로 리다이렉트
//        }

        // 사용자의 주문 수 가져오기
        int orderCount = memberService.getOrderCount(memberId);
//        model.addAttribute("orderCount", orderCount);

        Map<String, Object> map = new HashMap<>();

        String achievementImage;
        if (orderCount < 5) { //주문 수 5 이하
            achievementImage = "level1.png";
        } else if (orderCount < 10) { //주문 수 5 이상, 10 이하
            achievementImage = "level2.png";
        } else { // 주문 수가 10 이상
            achievementImage = "level3.png";
        }
//        model.addAttribute("achievementImage", achievementImage);
        map.put("achievementImage", achievementImage);

        return map;
    }
}
