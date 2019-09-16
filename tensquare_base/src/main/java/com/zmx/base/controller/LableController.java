package com.zmx.base.controller;

import com.zmx.base.pojo.Label;
import com.zmx.base.service.LabelService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/label")
public class LableController {

    @Autowired
    private LabelService labelService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(method= RequestMethod.GET)
    public Result findAll(){

        String header = request.getHeader("Authorization");
        System.out.println(header);
        return new Result(true, StatusCode.OK,"查询成功",labelService.findAll());

    }

    @RequestMapping(value="/{labelId}",method = RequestMethod.GET)
    public Result findById(@PathVariable("labelId") String labelId){

//        int i=1/0;
        //会返回
        return new Result(true, StatusCode.OK,"查询成功",labelService.findById(labelId));
    }

    @RequestMapping(method= RequestMethod.POST)
    public Result save(@RequestBody Label label){
//        不用返回
        labelService.save(label);
        return new Result(true, StatusCode.OK,"添加成功");
    }

    @RequestMapping(value="/{labelId}",method= RequestMethod.DELETE)
    public Result delteById(@PathVariable("labelId") String labelId){
        labelService.deleteById(labelId);
        return new Result(true, StatusCode.OK,"删除成功");
    }

    @RequestMapping(value = "/{labelId}",method = RequestMethod.PUT)
    public Result update(@PathVariable("labelId") String labelId,@RequestBody Label label){
        label.setId(labelId);
        labelService.update(label);
        return new Result(true, StatusCode.OK,"修改成功");
    }
    @RequestMapping(value = "/search",method=RequestMethod.POST)
    public Result findSearch(@RequestBody Label label){
        List<Label> list=labelService.findSearch(label);
        return new Result(true,StatusCode.OK,"查询成功",list);
    }

    @RequestMapping(value = "/search/{page}/{size}",method = RequestMethod.POST)
    public Result pageQuery(@RequestBody Label label,@PathVariable int page,@PathVariable int size){
        Page<Label> pageData=labelService.pageQuery(label,page,size);
        return new Result(true,StatusCode.OK,"查询成功",new PageResult<Label>(pageData.getTotalElements(),pageData.getContent()));
    }
}
