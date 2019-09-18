package com.candy.docs.portlet.displayContext;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;
import java.util.ArrayList;
import java.util.List;

public class CandyDisplayContext {

  public String getDataAsJson () {
    String[] CandyData = new String[]{
        "01%Candy%hello world",
        "02%Choco%hello Choco",
        "03%Hatoya%hello Toya"
    };
    List<JSONObject> jsonObjectsData = new ArrayList<>();
    for (String data : CandyData) {
      JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
      String[] entry = data.split(StringPool.PERCENT);
      jsonObject.put("id", entry[0]);
      jsonObject.put("name", entry[1]);
      jsonObject.put("text", entry[2]);
      jsonObjectsData.add(jsonObject);
    }
    return jsonObjectsData.toString();
  }
}
