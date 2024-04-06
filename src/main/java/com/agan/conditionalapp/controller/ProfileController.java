package com.agan.conditionalapp.controller;

import com.agan.conditionalapp.profile.SystemProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ProfileController {

    @Autowired
    public SystemProfile profileName;

    @GetMapping("profile")
    private String getProfile() {
        return profileName.getProfile();
    }

}
