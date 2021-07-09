package com.zkb.wiki.controller;

import com.zkb.wiki.domain.Ebook;
import com.zkb.wiki.resp.CommonResp;
import com.zkb.wiki.service.EbookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/ebook")
public class EbookController {
    @Resource
    private EbookService ebookService;


    @GetMapping("/list1")
    public CommonResp list(){
        CommonResp<List<Ebook>> resp = new CommonResp<>();
        List<Ebook>  list= ebookService.list();
        resp.setContent(list);
        return resp;
    }
}
