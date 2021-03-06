package com.myspring.cli.web;

import com.myspring.cli.model.ClassInfo;
import com.myspring.cli.pojo.ClassInfoDto;
import com.myspring.cli.pojo.TeacherDto;
import com.myspring.cli.pojo.TeacherNewDto;
import com.myspring.cli.service.ClassInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/ClassInfo")
@Api(value="班级模块",tags="班级模块")
public class ClassInfoController {
    @Autowired
    private ClassInfoService service;

    @ApiOperation(value = "根据班级ID返回班级信息")
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ClassInfo getClassInfo(@PathVariable("id") Long id) {
        ClassInfo info = service.getClassInfo(id);
        return info;
    }


    @ApiOperation(value = "返回所有信息")
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public Iterable<ClassInfo> getAll() {
        return service.getAllInfo();
    }

    @ApiOperation(value = "创建信息")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(ClassInfo Input) {
        service.Save(Input);
    }


    @ApiOperation(value = "删除")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(Long id) {
        service.Delete(id);
    }

    @ApiOperation(value = "测试DTO数据")
    @RequestMapping(value = "/GetDto", method = RequestMethod.POST)
    public ClassInfoDto GetDto(@RequestBody ClassInfo input){
        ClassInfoDto dto=new ClassInfoDto();
        BeanUtils.copyProperties(input,dto);
        return dto;
    }

    @ApiOperation(value = "测试automap数据转换")
    @RequestMapping(value = "/TestAutomapper", method = RequestMethod.GET)
    public TeacherDto TestAutoMapper(){
        TeacherDto techaerDto=new TeacherDto();
        TeacherDto techaerDtoData=new TeacherDto();
        techaerDto.setName("张三");
        techaerDto.setAge(19);
        techaerDto.setSex("男");
        List<ClassInfoDto> cdto=new ArrayList<>();
        ClassInfoDto c1=new ClassInfoDto();
        c1.setClassName("一班");
        c1.setGradeName("高一");
        cdto.add(c1);
        ClassInfoDto c2=new ClassInfoDto();
        c2.setClassName("二班");
        c2.setGradeName("高二");
        cdto.add(c2);
        techaerDto.setClassList(cdto);
        BeanUtils.copyProperties(techaerDto,techaerDtoData);
        return techaerDtoData;
    }


    @ApiOperation(value = "测试automap数据转换，不同数据类型")
    @RequestMapping(value = "/TestAutomapperNew", method = RequestMethod.GET)
    public TeacherNewDto TestAutoMapperNew(){
        TeacherDto techaerDto=new TeacherDto();
        TeacherNewDto techaerDtoData=new TeacherNewDto();
        techaerDto.setName("张三");
        techaerDto.setAge(19);
        techaerDto.setSex("男");
        List<ClassInfoDto> cdto=new ArrayList<>();
        ClassInfoDto c1=new ClassInfoDto();
        c1.setClassName("一班");
        c1.setGradeName("高一");
        cdto.add(c1);
        ClassInfoDto c2=new ClassInfoDto();
        c2.setClassName("二班");
        c2.setGradeName("高二");
        cdto.add(c2);
        techaerDto.setClassList(cdto);

        BeanUtils.copyProperties(techaerDto,techaerDtoData);

        return techaerDtoData;
    }


}
