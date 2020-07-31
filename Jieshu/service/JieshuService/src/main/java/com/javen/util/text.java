package com.javen.util;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;

public class text {

	public text() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws AlipayApiException {
//		String cn = "DNT,BOX版本号,十分,星期,1路电源状态,1路模式状态,1路设定温度,1路最大设定温度,1路测量温度,1路在线状态,1路加热,2路电源状态,2路模式状态,2路设定温度,2路最大设定温度,2路测量温度,2路在线状态,2路加热,3路电源状态,3路模式状态,3路设定温度,3路最大设定温度,3路测量温度,3路在线状态,3路加热,4路电源状态,4路模式状态,4路设定温度,4路最大设定温度,4路测量温度,4路在线状态,4路加热,5路电源状态,5路模式状态,5路设定温度,5路最大设定温度,5路测量温度,5路在线状态,5路加热,6路电源状态,6路模式状态,6路设定温度,6路最大设定温度,6路测量温度,6路在线状态,6路加热,7路电源状态,7路模式状态,7路设定温度,7路最大设定温度,7路测量温度,7路在线状态,7路加热";
//		String c = "DNT,V1,V2,V3,V1_1,V1_2,V1_3,V1_4,V1_5,V1_6,V1_7,V2_1,V2_2,V2_3,V2_4,V2_5,V2_6,V2_7,V3_1,V3_2,V3_3,V3_4,V3_5,V3_6,V3_7,V4_1,V4_2,V4_3,V4_4,V4_5,V4_6,V4_7,V5_1,V5_2,V5_3,V5_4,V5_5,V5_6,V5_7,V6_1,V6_2,V6_3,V6_4,V6_5,V6_6,V6_7,V7_1,V7_2,V7_3,V7_4,V7_5,V7_6,V7_7";
//		String c1[] = c.split(",");
//		String cn1[] = cn.split(",");
//		for (int i = 0; i < cn1.length; i++) {
//			System.out.println(c1[i]+"---"+cn1[i]);
//		}
		
		
		
		//AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do","2016092800616244","MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCAT6pZToNg6nZEWSMoPpYvNvZn8qVQc2k2qLM9WzEePtcQfedXCkHT+tWsDVQk3ZuNPTdjzrPczLMgYDqnJP/rUMLgEiqfKIsCadICI4s8UlCn/gf9PUeXSwx0Q2XnKraAiwOtqAzrYeG2MCeyKN6Cntwd1Tj2chtl7Xw4qlRN/MY53f+VSiajevM/ZZ8hHsW+De+y/UTtBfVKeSI6t4dciVo/0ncF3Y4jYtumh2nMaCAEyq5/axwIrj6LDcUW0c2DosWZTrpLFXdyXO5wAzvUxDGK38AEnnhoklTUg4Gb/AITRI0Q74IZmAkUqknUmX33IRSgPKbbZ+UU1kMtROR5AgMBAAECggEAMosvN27OIec6H0JdrwS4dHDaL6hNpptP3tAliw3ZE2j9nul5r7fCppYwhU3az4rcM47hutc50shv51kAwca5aSCvI0UEtR1rZM/6gg0uU9y5GPPggckZ4mcVyNaj1aPlsE0Sbd28+Rvdpb7iZDPlMt8RJk9P2QSp9kTOoiO2geF55TDcHI6yH+a8f8fKrCd4C+KRZEIfHFyYWkUChB84vh+jTPCDUYSue3WdhPRlCiA4lH01YNBWcV4s5uVCYW7xQ3g+a5lO20LOYnMWq+yoASrEyMFaAHzaQatEHCuWBr6NnUK97sbbEovAnqOOfqQ/90Ct8WA9g2r3+lOjHcOYAQKBgQC9owF6q85Xl5ZiSqjSQLVnHiOu99b3vA3EB296vH2Q8eB0zNA0yptaC7a7W7w0R60anwO2Dr5uEpgodTOHMCSJPRsQ7LqQvwhyi4QIlmU2DOoBthAO3WRV6BnPcbMQlCspFY5uNogKs44xF7O6UBWT6tWPL3EDUzn8YybzcxpjGQKBgQCtNq9yS4IrFXu6EGGgBAKD9MXd+d2FnERh5x6hIqlftvjY8u5sak06/iqmGPSFQqzfluei3KqLg83pnCNK7J0OdyUUOr3x+GZokXkOKOo4aktA2jlplCjQQCh/mbbLwv2gT6gMHbVZy1r3slnU6QAATiIPI2MDP22oOZ8nQTMYYQKBgDuFYD96kWdYwvDS8i4b9VQKV7ThQW28bq2qj8j8RIUsBgFjD66iMSSQLKid4HKgVKrYYjfQZODzoSKBtsylxbH1pfsn8l7gNuyM8cIoQlg2sXQcCuo/fvCfywoba9K2Tt20UGIzZ3vEY8rw346I+FzXBnTMtTIP+1FGZcFfzVZxAoGBAKdiGAsIAsLloMm9+Mkr9s5TZD5Mrg/mYYKGWGf4Wdp/s1va7iHgW79tTAN0TB7Wvr3WUwNj4H6voPVmCAjoPCF1a2RwG4vPsg7MvUG8shJQTWZfO2nWXdZYmYotHaMsS/F16HvE3bHnPIHuXLbNbk3dMzaTyKOj0LDm9fB2Jg0hAoGAJr5+if1lLXVUFF6bI0jNbHltbPoltbttvOBbwkFUwPbTN2bMZTNM0baa6ZwiHGMOy7+9r+wt0yYEgK4DcRfAE0oPA2r1PGjWfrBZvRrkE+lK6yNjlzqi6XDNkzCdIBnqwbYJBWXCk7mcvUsh2drejNke8geCngEYRer0z4qzOzM=","json","GBK","MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgE+qWU6DYOp2RFkjKD6WLzb2Z/KlUHNpNqizPVsxHj7XEH3nVwpB0/rVrA1UJN2bjT03Y86z3MyzIGA6pyT/61DC4BIqnyiLAmnSAiOLPFJQp/4H/T1Hl0sMdENl5yq2gIsDragM62HhtjAnsijegp7cHdU49nIbZe18OKpUTfzGOd3/lUomo3rzP2WfIR7Fvg3vsv1E7QX1SnkiOreHXIlaP9J3Bd2OI2LbpodpzGggBMquf2scCK4+iw3FFtHNg6LFmU66SxV3clzucAM71MQxit/ABJ54aJJU1IOBm/wCE0SNEO+CGZgJFKpJ1Jl99yEUoDym22flFNZDLUTkeQIDAQAB","RSA2");

		//		AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do","2016092800616244","MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCAT6pZToNg6nZEWSMoPpYvNvZn8qVQc2k2qLM9WzEePtcQfedXCkHT+tWsDVQk3ZuNPTdjzrPczLMgYDqnJP/rUMLgEiqfKIsCadICI4s8UlCn/gf9PUeXSwx0Q2XnKraAiwOtqAzrYeG2MCeyKN6Cntwd1Tj2chtl7Xw4qlRN/MY53f+VSiajevM/ZZ8hHsW+De+y/UTtBfVKeSI6t4dciVo/0ncF3Y4jYtumh2nMaCAEyq5/axwIrj6LDcUW0c2DosWZTrpLFXdyXO5wAzvUxDGK38AEnnhoklTUg4Gb/AITRI0Q74IZmAkUqknUmX33IRSgPKbbZ+UU1kMtROR5AgMBAAECggEAMosvN27OIec6H0JdrwS4dHDaL6hNpptP3tAliw3ZE2j9nul5r7fCppYwhU3az4rcM47hutc50shv51kAwca5aSCvI0UEtR1rZM/6gg0uU9y5GPPggckZ4mcVyNaj1aPlsE0Sbd28+Rvdpb7iZDPlMt8RJk9P2QSp9kTOoiO2geF55TDcHI6yH+a8f8fKrCd4C+KRZEIfHFyYWkUChB84vh+jTPCDUYSue3WdhPRlCiA4lH01YNBWcV4s5uVCYW7xQ3g+a5lO20LOYnMWq+yoASrEyMFaAHzaQatEHCuWBr6NnUK97sbbEovAnqOOfqQ/90Ct8WA9g2r3+lOjHcOYAQKBgQC9owF6q85Xl5ZiSqjSQLVnHiOu99b3vA3EB296vH2Q8eB0zNA0yptaC7a7W7w0R60anwO2Dr5uEpgodTOHMCSJPRsQ7LqQvwhyi4QIlmU2DOoBthAO3WRV6BnPcbMQlCspFY5uNogKs44xF7O6UBWT6tWPL3EDUzn8YybzcxpjGQKBgQCtNq9yS4IrFXu6EGGgBAKD9MXd+d2FnERh5x6hIqlftvjY8u5sak06/iqmGPSFQqzfluei3KqLg83pnCNK7J0OdyUUOr3x+GZokXkOKOo4aktA2jlplCjQQCh/mbbLwv2gT6gMHbVZy1r3slnU6QAATiIPI2MDP22oOZ8nQTMYYQKBgDuFYD96kWdYwvDS8i4b9VQKV7ThQW28bq2qj8j8RIUsBgFjD66iMSSQLKid4HKgVKrYYjfQZODzoSKBtsylxbH1pfsn8l7gNuyM8cIoQlg2sXQcCuo/fvCfywoba9K2Tt20UGIzZ3vEY8rw346I+FzXBnTMtTIP+1FGZcFfzVZxAoGBAKdiGAsIAsLloMm9+Mkr9s5TZD5Mrg/mYYKGWGf4Wdp/s1va7iHgW79tTAN0TB7Wvr3WUwNj4H6voPVmCAjoPCF1a2RwG4vPsg7MvUG8shJQTWZfO2nWXdZYmYotHaMsS/F16HvE3bHnPIHuXLbNbk3dMzaTyKOj0LDm9fB2Jg0hAoGAJr5+if1lLXVUFF6bI0jNbHltbPoltbttvOBbwkFUwPbTN2bMZTNM0baa6ZwiHGMOy7+9r+wt0yYEgK4DcRfAE0oPA2r1PGjWfrBZvRrkE+lK6yNjlzqi6XDNkzCdIBnqwbYJBWXCk7mcvUsh2drejNke8geCngEYRer0z4qzOzM=","json","GBK","MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA4+Ma+i+BudcjSeFiaZQyb5WbgcYL057SeLhjaF/Cb8oiLDFCmoY1mCg/jR+LrN388tYSv95vu35u8S1Jj8dmInYmFQAezbbBxhWIk5lRL1kQWPnRvXh4KKziarLPOeCnSPrb11/ZJIPM6SIufGzS69z7beukxHRWcUa76oHKadBYRI8/t4Ar2v4VEhW+qyXh48Qwt5V9ZO0vkWHnCx+jfS/cTA6XAgHVz1WamEBUNCUulFRCsh3IW2hLicMDlwERkumbPNobrzFPqIVZuTcdthnsTz92wunMbhFxIetSmBlbykTMBxWSA5gnXZpc2MwSeKhwL6p61Rnf4lM+NCZLXwIDAQAB","RSA2");
//		AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
//		request.setBizContent("{" +
//		"\"out_trade_no\":\"031316132078841\"," +
//		"\"trade_no\":\"2019031322001403160500600685\"," +
//		"\"refund_amount\":222.00  }");
//		AlipayTradeRefundResponse response = alipayClient.execute(request);
//		if(response.isSuccess()){
//		System.out.println("调用成功");
//		} else {
//		System.out.println("调用失败");
//		}
		
		new text().payBack("031316132078841", "2019031322001403160500600876", 222.0);
		
	}
	
	
	public void payBack(String out_trade_no,String trade_no,double refund_amount) {
		AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do",
				"2016092800616244",
				"MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCAT6pZToNg6nZEWSMoPpYvNvZn8qVQc2k2qLM9WzEePtcQfedXCkHT+tWsDVQk3ZuNPTdjzrPczLMgYDqnJP/rUMLgEiqfKIsCadICI4s8UlCn/gf9PUeXSwx0Q2XnKraAiwOtqAzrYeG2MCeyKN6Cntwd1Tj2chtl7Xw4qlRN/MY53f+VSiajevM/ZZ8hHsW+De+y/UTtBfVKeSI6t4dciVo/0ncF3Y4jYtumh2nMaCAEyq5/axwIrj6LDcUW0c2DosWZTrpLFXdyXO5wAzvUxDGK38AEnnhoklTUg4Gb/AITRI0Q74IZmAkUqknUmX33IRSgPKbbZ+UU1kMtROR5AgMBAAECggEAMosvN27OIec6H0JdrwS4dHDaL6hNpptP3tAliw3ZE2j9nul5r7fCppYwhU3az4rcM47hutc50shv51kAwca5aSCvI0UEtR1rZM/6gg0uU9y5GPPggckZ4mcVyNaj1aPlsE0Sbd28+Rvdpb7iZDPlMt8RJk9P2QSp9kTOoiO2geF55TDcHI6yH+a8f8fKrCd4C+KRZEIfHFyYWkUChB84vh+jTPCDUYSue3WdhPRlCiA4lH01YNBWcV4s5uVCYW7xQ3g+a5lO20LOYnMWq+yoASrEyMFaAHzaQatEHCuWBr6NnUK97sbbEovAnqOOfqQ/90Ct8WA9g2r3+lOjHcOYAQKBgQC9owF6q85Xl5ZiSqjSQLVnHiOu99b3vA3EB296vH2Q8eB0zNA0yptaC7a7W7w0R60anwO2Dr5uEpgodTOHMCSJPRsQ7LqQvwhyi4QIlmU2DOoBthAO3WRV6BnPcbMQlCspFY5uNogKs44xF7O6UBWT6tWPL3EDUzn8YybzcxpjGQKBgQCtNq9yS4IrFXu6EGGgBAKD9MXd+d2FnERh5x6hIqlftvjY8u5sak06/iqmGPSFQqzfluei3KqLg83pnCNK7J0OdyUUOr3x+GZokXkOKOo4aktA2jlplCjQQCh/mbbLwv2gT6gMHbVZy1r3slnU6QAATiIPI2MDP22oOZ8nQTMYYQKBgDuFYD96kWdYwvDS8i4b9VQKV7ThQW28bq2qj8j8RIUsBgFjD66iMSSQLKid4HKgVKrYYjfQZODzoSKBtsylxbH1pfsn8l7gNuyM8cIoQlg2sXQcCuo/fvCfywoba9K2Tt20UGIzZ3vEY8rw346I+FzXBnTMtTIP+1FGZcFfzVZxAoGBAKdiGAsIAsLloMm9+Mkr9s5TZD5Mrg/mYYKGWGf4Wdp/s1va7iHgW79tTAN0TB7Wvr3WUwNj4H6voPVmCAjoPCF1a2RwG4vPsg7MvUG8shJQTWZfO2nWXdZYmYotHaMsS/F16HvE3bHnPIHuXLbNbk3dMzaTyKOj0LDm9fB2Jg0hAoGAJr5+if1lLXVUFF6bI0jNbHltbPoltbttvOBbwkFUwPbTN2bMZTNM0baa6ZwiHGMOy7+9r+wt0yYEgK4DcRfAE0oPA2r1PGjWfrBZvRrkE+lK6yNjlzqi6XDNkzCdIBnqwbYJBWXCk7mcvUsh2drejNke8geCngEYRer0z4qzOzM=",
				"json", "GBK",
				"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA4+Ma+i+BudcjSeFiaZQyb5WbgcYL057SeLhjaF/Cb8oiLDFCmoY1mCg/jR+LrN388tYSv95vu35u8S1Jj8dmInYmFQAezbbBxhWIk5lRL1kQWPnRvXh4KKziarLPOeCnSPrb11/ZJIPM6SIufGzS69z7beukxHRWcUa76oHKadBYRI8/t4Ar2v4VEhW+qyXh48Qwt5V9ZO0vkWHnCx+jfS/cTA6XAgHVz1WamEBUNCUulFRCsh3IW2hLicMDlwERkumbPNobrzFPqIVZuTcdthnsTz92wunMbhFxIetSmBlbykTMBxWSA5gnXZpc2MwSeKhwL6p61Rnf4lM+NCZLXwIDAQAB",
				"RSA2");
		AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
		JSONObject object = new JSONObject();
		object.put("out_trade_no", out_trade_no);
		object.put("trade_no", trade_no);
		object.put("refund_amount", refund_amount);
		request.setBizContent(object.toString());
		AlipayTradeRefundResponse response;
		try {
			response = alipayClient.execute(request);
			if (response.isSuccess()) {
				System.out.println("调用支付宝退款成功");
			} else {
				System.out.println("调用支付宝退款失败");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
