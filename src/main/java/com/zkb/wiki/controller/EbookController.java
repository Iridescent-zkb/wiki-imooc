package com.zkb.wiki.controller;

import com.zkb.wiki.req.EbookQueryReq;
import com.zkb.wiki.req.EbookSaveReq;
import com.zkb.wiki.resp.CommonResp;
import com.zkb.wiki.resp.EbookQueryResp;
import com.zkb.wiki.resp.PageResp;
import com.zkb.wiki.service.EbookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/ebook")
public class EbookController {
    @Resource
    private EbookService ebookService;


    @GetMapping("/list")
    public CommonResp list(EbookQueryReq req){
        CommonResp<PageResp<EbookQueryResp>> resp = new CommonResp<>();
        PageResp<EbookQueryResp> list= ebookService.list(req);
        resp.setContent(list);
        return resp;
    }
    @PostMapping("/save")
    public CommonResp save(@RequestBody EbookSaveReq req){
        CommonResp resp = new CommonResp<>();
         ebookService.save(req);
        return resp;
    }
}
