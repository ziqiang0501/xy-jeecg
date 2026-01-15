package org.jeecg.modules.demo.xy.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.system.query.QueryRuleEnum;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.demo.xy.entity.TestDemo;
import org.jeecg.modules.demo.xy.service.ITestDemoService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;
 /**
 * @Description: 测试用户表
 * @Author: jeecg-boot
 * @Date:   2026-01-15
 * @Version: V1.0
 */
@Tag(name="测试用户表")
@RestController
@RequestMapping("/xy/testDemo")
@Slf4j
public class TestDemoController extends JeecgController<TestDemo, ITestDemoService> {
	@Autowired
	private ITestDemoService testDemoService;
	
	/**
	 * 分页列表查询
	 *
	 * @param testDemo
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "测试用户表-分页列表查询")
	@Operation(summary="测试用户表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<TestDemo>> queryPageList(TestDemo testDemo,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {


        // 自定义查询规则
        Map<String, QueryRuleEnum> customeRuleMap = new HashMap<>();
        // 自定义多选的查询规则为：LIKE_WITH_OR
        customeRuleMap.put("sex", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("ceck", QueryRuleEnum.LIKE_WITH_OR);
        customeRuleMap.put("xiamuti", QueryRuleEnum.LIKE_WITH_OR);
        QueryWrapper<TestDemo> queryWrapper = QueryGenerator.initQueryWrapper(testDemo, req.getParameterMap(),customeRuleMap);
		Page<TestDemo> page = new Page<TestDemo>(pageNo, pageSize);
		IPage<TestDemo> pageList = testDemoService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param testDemo
	 * @return
	 */
	@AutoLog(value = "测试用户表-添加")
	@Operation(summary="测试用户表-添加")
	@RequiresPermissions("xy:test_demo:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody TestDemo testDemo) {
		testDemoService.save(testDemo);

		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param testDemo
	 * @return
	 */
	@AutoLog(value = "测试用户表-编辑")
	@Operation(summary="测试用户表-编辑")
	@RequiresPermissions("xy:test_demo:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody TestDemo testDemo) {
		testDemoService.updateById(testDemo);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "测试用户表-通过id删除")
	@Operation(summary="测试用户表-通过id删除")
	@RequiresPermissions("xy:test_demo:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		testDemoService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "测试用户表-批量删除")
	@Operation(summary="测试用户表-批量删除")
	@RequiresPermissions("xy:test_demo:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.testDemoService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "测试用户表-通过id查询")
	@Operation(summary="测试用户表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<TestDemo> queryById(@RequestParam(name="id",required=true) String id) {
		TestDemo testDemo = testDemoService.getById(id);
		if(testDemo==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(testDemo);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param testDemo
    */
    @RequiresPermissions("xy:test_demo:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, TestDemo testDemo) {
        return super.exportXls(request, testDemo, TestDemo.class, "测试用户表");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("xy:test_demo:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, TestDemo.class);
    }

}
