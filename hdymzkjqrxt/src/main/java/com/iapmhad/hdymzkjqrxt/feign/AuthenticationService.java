package com.iapmhad.hdymzkjqrxt.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("member")
public interface AuthenticationService {

    @RequestMapping("/member/user/authentication/{username}")
    public String authentication(@PathVariable("username") String username);
}
