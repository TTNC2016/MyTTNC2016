package com.tfarm.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tfarm.service.TTTService;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class TTAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1744733378086073973L;
	private static Logger logger = LoggerFactory.getLogger(TTAction.class);

	@Resource
	private TTTService tService;

	/**
	 * test 的返回list、map到页面
	 * 
	 * @return
	 */

	// @Action(value = "/mgrbus/getReply", results = { @Result(name = SUCCESS,
	// location = "/admin/test.jsp") })
	@Action(value = "/getMap", results = {
			@Result(name = SUCCESS, location = "/admin/aa.jsp"),
			@Result(name = ERROR, location = "/admin/index.jsp") })
	public String getMapOrList() {
		List<Map<String, Object>> list = this.tService.getTest();
		ServletActionContext.getRequest().setAttribute("list", list);
		return SUCCESS;
	}

	@Action(value = "/test")
	public void test() {
		try {
			JSONArray json = new JSONArray();
			JSONObject jo = new JSONObject();
			jo.put("type", "a");
			jo.put("supplier", "12308");
			json.add(jo);

			JSONObject jo1 = new JSONObject();
			jo1.put("type", "a");
			jo1.put("supplier", "hthy");
			json.add(jo1);

			JSONObject jo2 = new JSONObject();
			jo2.put("type", "b");
			jo2.put("supplier", "12308");
			json.add(jo2);

			JSONObject jo3 = new JSONObject();
			jo3.put("type", "b");
			jo3.put("supplier", "zhizhu");
			json.add(jo2);

			JSONObject jo11 = new JSONObject();
			jo11.put("type", "b");
			jo11.put("supplier", "hthy");
			json.add(jo11);
			writeJSON(json);

			List<Map<String, Object>> list = this.tService.getTest();
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> map = list.get(i);
				System.out.println((String) map.get("a") + "==="
						+ (String) map.get("b"));
			}

			HttpServletRequest request = ServletActionContext.getRequest();
			Map<String, String[]> params = request.getParameterMap();
			String queryString = "";
			for (String key : params.keySet()) {
				String[] values = params.get(key);
				for (int i = 0; i < values.length; i++) {
					String value = values[i];
					queryString += key + "=" + value + "&";
				}
			}
			// 去掉最后一个空格
			// queryString = queryString.substring(0, queryString.length() - 1);
			logger.info(queryString);

		} catch (Exception e) {
			logger.error("", e);
		}

	}

	/**
	 * 将JSON对象写入到response
	 * 
	 * @param jsonObject
	 * @throws Exception
	 */
	protected void writeJSON(Object jsonObject) throws Exception {
		Gson gson = new Gson();
		String result = gson.toJson(jsonObject);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(result);
	}
}
