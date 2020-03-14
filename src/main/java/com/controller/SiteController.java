package com.controller;

import com.entity.MonitoringType;
import com.entity.Site;
import com.repository.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/site")
public class SiteController {
    @Autowired
    private SiteRepository siteRepository;

    @GetMapping(path = "sitesStatus")
    public @ResponseBody
    Iterable<Site> getSitesStatus(int status) {
        return siteRepository.findByStatus(status);
    }

    @GetMapping(path = "/list")
    public @ResponseBody
    Iterable<Site> getAllUsersSites() { return siteRepository.findAll(); }

    @GetMapping(path = "/listSite")
    public @ResponseBody
    Iterable<Site> getUserSites(@RequestParam Long userId) {
        return siteRepository.findByUserId(userId);
    }

    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewMonitoring(@RequestParam Long userId,
                            @RequestParam String friendlySiteName,
                            @RequestParam String siteName,
                            @RequestParam MonitoringType monitoringType,
                            @RequestParam long interval,
                            String keywordExist,
                            String keywordNotExist){
        Site site = new Site();
        site.setUserId(userId);
        site.setFriendlySiteName(friendlySiteName);
        site.setSiteName(siteName);
        site.setMonitoringType(monitoringType);
        site.setMonitoringInterval(interval);
        if (monitoringType.equals(MonitoringType.KEYWORD)) {
            site.setKeywordExist(keywordExist);
            site.setKeywordNotExist(keywordNotExist);
        }
        siteRepository.save(site);
        return "Site " + siteName +" - added";
    }

    @PostMapping(path = "update")
    public @ResponseBody
    String editMonitoring(@RequestParam Long id,
                          @RequestParam String friendlySiteName,
                          @RequestParam String siteName,
                          @RequestParam long interval) {
        String message;
        try {
            Site site = siteRepository.findById(id);
            site.setFriendlySiteName(friendlySiteName);
            site.setSiteName(siteName);
            site.setMonitoringInterval(interval);
            siteRepository.save(site);
            message = "edited";
        } catch (Exception ex) {
            message = "ERROR !!! Cannot be edited. Something wrong.";
        }
        return message;
    }

    @DeleteMapping(path = "/delete")
    public @ResponseBody
    String deleteMonitoring(@RequestParam Long id) {
        String message;
        try {
            Site site = siteRepository.findById(id);
            siteRepository.delete(site);
            message = "deleted";
        } catch (Exception ex) {
            message = "ERROR !!! Can NOT be deleted";
        }
        return message;
    }
}
