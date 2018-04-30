package com.internousdev.ecsite.action;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport implements SessionAware {
	public Map<String, Object> session;
//	在庫処理で使用するために選択された商品のitemInfoListでのインデックスをを表す変数buyItemIndex
	private String buyItemIndex;
	private int buyItemId;
	private String buyItemName;
	private int buyItemPrice;
	private int count;
	private String pay;

	@SuppressWarnings("unchecked")
	public String execute(){
		List<Map<String,Object>> cartList = (List<Map<String,Object>>) session.get("cartList");
		List<String> checkItemList = (List<String>) session.get("checkItemList");



		//cartListの中にすでにある商品と、ない商品で分岐
		if(((List<String>) session.get("checkItemList")).contains(buyItemIndex)){
			for(int i = 0; i<cartList.size(); i++){
				Map<String,Object> buyItemInfoMap = cartList.get(i);
				if((boolean) buyItemInfoMap.get("buyItemId").equals(buyItemId)){
					//個数を増やす
					int cnt = (int) buyItemInfoMap.get("count");
					int cartCount = cnt + count;
					buyItemInfoMap.put("count", cartCount);
					//合計金額を増やす
					int totalPrice = (int) buyItemInfoMap.get("totalPrice");
					totalPrice += buyItemPrice * count;
					buyItemInfoMap.put("totalPrice", totalPrice);

					cartList.set(i,buyItemInfoMap);
					session.put("cartList", cartList);
					break;
				}
			}
		}else{
			checkItemList.add(buyItemIndex);
			session.put("checkItemList", checkItemList);

			Map<String,Object> buyItemInfoMap = new HashMap<String,Object>();
			buyItemInfoMap.put("buyItemIndex", buyItemIndex);
			buyItemInfoMap.put("buyItemId",buyItemId);
			buyItemInfoMap.put("buyItemName",buyItemName);
			buyItemInfoMap.put("buyItemPrice",buyItemPrice);
			buyItemInfoMap.put("count",count);

			//支払い方法
			if(pay.equals("1")){
				pay = "現金払い";
			}else{
				pay = "クレジットカード";
			}
			buyItemInfoMap.put("pay",pay);

			//合計金額を計算
			int totalPrice = buyItemPrice * count;
			buyItemInfoMap.put("totalPrice", totalPrice);

			cartList.add(buyItemInfoMap);
			session.put("cartList", cartList);

		}


		//--------ここから----------
		//buyItem.jspに戻ったときに在庫を減らすための処理。
		//セッション内のitemInfoListの中のbuyItemDTOのitemStockフィールドの個数を減らす。
		//フィールドbuyItemIndexはbuyItem.jspで購入された商品のitemInfoListでの添字を表す。
		BuyItemDTO buyItemDTO = new BuyItemDTO();
		List<BuyItemDTO> itemInfoList = (List<BuyItemDTO>) session.get("itemInfoList");
		buyItemDTO = itemInfoList.get(Integer.parseInt(buyItemIndex));
		int stock =  buyItemDTO.getItemStock();
		stock -= count;
		buyItemDTO.setItemStock(stock);
		itemInfoList.set(Integer.parseInt(buyItemIndex),buyItemDTO);
		session.put("itemInfoList",itemInfoList);
		//---------ここまで---------


		return SUCCESS;
	}

	public String getBuyItemIndex() {
		return buyItemIndex;
	}

	public void setBuyItemIndex(String buyItemIndex) {
		this.buyItemIndex = buyItemIndex;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}


	public int getBuyItemId() {
		return buyItemId;
	}

	public void setBuyItemId(int buyItemId) {
		this.buyItemId = buyItemId;
	}


	public String getBuyItemName() {
		return buyItemName;
	}


	public void setBuyItemName(String buyItemName) {
		this.buyItemName = buyItemName;
	}


	public int getBuyItemPrice() {
		return buyItemPrice;
	}


	public void setBuyItemPrice(int buyItemPrice) {
		this.buyItemPrice = buyItemPrice;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}
}
