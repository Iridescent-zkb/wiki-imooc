package com.zkb.wiki.service;

import com.zkb.wiki.domain.Ebook;
import com.zkb.wiki.domain.EbookExample;
import com.zkb.wiki.mapper.EbookMapper;
import com.zkb.wiki.req.EbookReq;
import com.zkb.wiki.resp.EbookResp;
import com.zkb.wiki.util.CopyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EbookService {

    @Resource
    private EbookMapper ebookMapper;

    public List<EbookResp> list(EbookReq req){
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        criteria.andNameLike("%"+req.getName()+"%");
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);

//        List<EbookResp> respList = new ArrayList<>();
//        for (Ebook ebook : ebookList ){
//           // EbookResp ebookResp = new EbookResp();
//           // BeanUtils.copyProperties(ebook,ebookResp);
//
//            //对象复制
//            EbookResp ebookResp = CopyUtil.copy(ebook, EbookResp.class);
//            respList.add(ebookResp);
//        }

        //列表复制
        List<EbookResp> list = CopyUtil.copyList(ebookList,EbookResp.class);
        return list;
    }
}
