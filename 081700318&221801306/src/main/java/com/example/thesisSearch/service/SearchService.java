package com.example.thesisSearch.service;

import com.example.thesisSearch.dao.ThesisDAO;
import com.example.thesisSearch.javabean.PageBean;
import com.example.thesisSearch.pojo.Thesis;

import java.util.List;

public class SearchService {
      static  public int pagesize=5;
      static  public  PageBean search(String type, String input,ThesisDAO SearchThesisDAO,int PageNum)
    {
        PageBean SearchResult=null;
        if (type.equals("title"))
        {
            int TotalResultNum=SearchThesisDAO.getNumBytitle(input);
            int SearchStart=(PageNum-1)*pagesize;
            int SearchLength=PageNum*pagesize<TotalResultNum?5:TotalResultNum-(PageNum-1)*pagesize;
            SearchResult=new PageBean(PageNum,pagesize,TotalResultNum,SearchThesisDAO.getLimitBytitile(SearchStart,SearchLength,input),type,input);//构建一个pagebean并且传出
        }
        else if(type.equals("keyword"))
        {

        }
        else if(type.equals("content"))
        {
        }
        else {
        }
        return  SearchResult;
    }
}