//package com.zjs.saturn.service;
//
//import com.zjs.saturn.bean.SysDict;
//import com.zjs.saturn.bean.SysDictExample;
//import com.zjs.saturn.dao.SysDictMapper;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
//
//import javax.annotation.Resource;
//import java.util.List;
//
//@Service
//public class SysDictService {
//
//    @Resource
//    private SysDictMapper sysDictMapper;
//
//    public SysDict getDictByTypeCode(String typeCode, Long parentId, String owner){
//
//        if(StringUtils.isEmpty(typeCode) || parentId == null){
//            return null;
//        }
//        SysDictExample example = new SysDictExample();
//        SysDictExample.Criteria criteria = example.createCriteria();
//        criteria.andDeletedEqualTo("N");
//        criteria.andParentIdEqualTo(parentId);
//        criteria.andTypeCodeEqualTo(typeCode);
//        if (!StringUtils.isEmpty(owner)){
//            criteria.andOwnerEqualTo(owner);
//        }
//        List<SysDict> sysDicts = sysDictMapper.selectByExampleWithBLOBs(example);
//        if(sysDicts.isEmpty()){
//            return null;
//        }
//        return sysDicts.get(0);
//    }
//
//
//    public List<SysDict> listDictByExample(  SysDictExample example){
//        return  sysDictMapper.selectByExample(example);
//    }
//
//    public int save(SysDict dict){
//
//        return sysDictMapper.insert(dict);
//
//    }
//
//
//}
