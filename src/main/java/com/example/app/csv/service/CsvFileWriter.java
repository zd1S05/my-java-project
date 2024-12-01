package com.example.app.csv.service;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import com.example.app.csv.domain.ImagesForCsv;
import com.example.app.csv.domain.ItemForCsv;
import com.example.app.csv.domain.ItemPolicy;
import com.example.app.csv.domain.Payment;
import com.example.app.csv.domain.ShippingMethod1;
import com.example.app.csv.domain.ShippingMethod2;
import com.example.app.csv.domain.ShippingMethod3;
import com.example.app.csv.domain.SubItem;
import com.example.app.csv.mapper.ImagesForCsvMapper;
import com.example.app.csv.mapper.ItemPolicyMapper;
import com.example.app.csv.mapper.PaymentMapper;
import com.example.app.csv.mapper.ShippingMethod1Mapper;
import com.example.app.csv.mapper.ShippingMethod2Mapper;
import com.example.app.csv.mapper.ShippingMethod3Mapper;
import com.example.app.csv.mapper.SubItemMapper;
import com.opencsv.CSVWriter;

public class CsvFileWriter {
	
	private static String checkNull(Object value) {
		return value == null ? "" : value.toString();
	}
	
	public static void writerItemsToCsv(List<ItemForCsv> items,
							   ImagesForCsvMapper imagesmapper,
							   ItemPolicyMapper itempolicymapper,
							   PaymentMapper paymentmapper,
							   ShippingMethod1Mapper shippingmethod1mapper,
							   ShippingMethod2Mapper shippingmethod2mapper,
							   ShippingMethod3Mapper shippingmethod3mapper,
							   SubItemMapper subitemmapper,
							   Path outpuPath) {
		try(CSVWriter writer = new CSVWriter(new FileWriter(outpuPath.toFile()))){
			
			String[] header = {"カテゴリ","タイトル","説明","開始価格",
							    "即決価格","個数","開催期間","終了時間","JANコード",
							    "画像1","画像1コメント","画像2",
							    "画像2コメント","画像3","画像3コメント","画像4","画像4コメント","画像5","画像5コメント","画像6",
							    "画像6コメント","画像7","画像7コメント","画像8","画像8コメント","画像9","画像9コメント","画像10",
							    "画像10コメント","商品発送元の都道府県","商品発送元の市区町村","送料負担","代金支払い","Yahoo!かんたん決済",
							    "かんたん取引","商品代引","商品の状態","商品の状態備考","返品の可否","返品の可否備考","入札者評価制限",
							    "悪い評価の割合での制限","入札者認証制限","自動延長","早期終了","値下げ交渉","自動再出品","自動値下げ価格変更率",
							    "注目のオークション","おすすめコレクション","送料固定","荷物の大きさ","荷物の重量","ネコポス","ネコ宅急便コンパクト",
							    "ネコ宅急便","ゆうパケット","ゆうパック","ゆうパケットポストmini","ゆうパケットプラス","発送までの日数","配送方法1",
							    "配送方法1全国一律価格","北海道料金1","沖縄料金1","離島料金1","配送方法2","配送方法2全国一律価格","北海道料金2",
							    "沖縄料金2","離島料金2","配送方法3","配送方法3全国一律価格","北海道料金3","沖縄料金3","離島料金3","配送方法4",
							    "配送方法4全国一律価格","北海道料金4","沖縄料金4","離島料金4","配送方法5","配送方法5全国一律価格","北海道料金5",
							    "沖縄料金5","離島料金5","配送方法6","配送方法6全国一律価格","北海道料金6","沖縄料金6","離島料金6","配送方法7",
							    "配送方法7全国一律価格","北海道料金7","沖縄料金7","離島料金7","配送方法8","配送方法8全国一律価格","北海道料金8",
							    "沖縄料金8","離島料金8","配送方法9","配送方法9全国一律価格","北海道料金9","沖縄料金9","離島料金9","配送方法10",
							    "配送方法10全国一律価格","北海道料金10","沖縄料金10","離島料金10","受け取り後決済サービス","海外発送"};
			writer.writeNext(header);
			
			for(ItemForCsv item : items) {
				
				System.out.println("CsvFileWriter.javaの"+item);
				
				ItemPolicy itemPolicyForItem = itempolicymapper.selectById(item.getItemPolicyId());
				ImagesForCsv imagesForItem = imagesmapper.selectByItemId(item.getId());
				Payment paymentForItem = paymentmapper.selectById(item.getPaymentId());
				ShippingMethod1 method1ForItem = shippingmethod1mapper.selectById(item.getShippingMethod1Id());
				ShippingMethod2 method2ForItem = shippingmethod2mapper.selectById(item.getShippingMethod2Id());
				ShippingMethod3 method3ForItem = shippingmethod3mapper.selectById(item.getShippingMethod3Id());
				SubItem subItemForItem = subitemmapper.selectById(item.getSubItemId());
				
				String[] data = {
						checkNull(item.getCategory()) ,//カテゴリ
						checkNull(item.getTitle()),//タイトル
					    checkNull(item.getDescription()),//説明
					    checkNull(item.getStartingPrice()),//開始価格
					    checkNull(subItemForItem.getInitialPrice()),//即決価格
					    checkNull(subItemForItem.getItemCount()),//個数
					    checkNull(item.getEventDuration()),//開催期間
					    checkNull(item.getEndTime()),//終了時間
					    checkNull(subItemForItem.getJanCode()),//JANコード					
					    checkNull(imagesForItem.getImage1()),//画像1
					    checkNull(imagesForItem.getImage1Comment()),//画像1コメント
					    checkNull(imagesForItem.getImage2()),//画像2
					    checkNull(imagesForItem.getImage2Comment()),//画像2コメント
					    checkNull(imagesForItem.getImage3()),//画像3
					    checkNull(imagesForItem.getImage3Comment()),//画像3コメント
					    checkNull(imagesForItem.getImage4()),//画像4						    	
					    checkNull(imagesForItem.getImage4Comment()),//画像4コメント
					    checkNull(imagesForItem.getImage5()),//画像5
					    checkNull(imagesForItem.getImage5Comment()),//画像5コメン
					    checkNull(imagesForItem.getImage6()),//画像6
					    checkNull(imagesForItem.getImage6Comment()),//画像6コメント
					    checkNull(imagesForItem.getImage7()),//画像7
					    checkNull(imagesForItem.getImage7Comment()),//画像7コメント
					    checkNull(imagesForItem.getImage8()),//画像8
					    checkNull(imagesForItem.getImage8Comment()),//画像8コメント
					    checkNull(imagesForItem.getImage9()),//画像9
					    checkNull(imagesForItem.getImage9Comment()),//画像9コメント
					    checkNull(imagesForItem.getImage10()),//画像10
					    checkNull(imagesForItem.getImage10Comment()),//画像10コメント
					    checkNull(method2ForItem.getShippingProvince()),//商品発送元の都道府県,
					    checkNull(method2ForItem.getShippingCity()),//商品発送元の市区町村,
					    checkNull(paymentForItem.getShippingFeePayer()),//送料負担,
					    checkNull(paymentForItem.getPaymentMethod()),//代金支払い,
					    checkNull(paymentForItem.getYahooPaymentMethod()),//Yahoo!かんたん決済,
					    checkNull(paymentForItem.getBankId1()),//かんたん取引,
					    checkNull(paymentForItem.getCodPayment()),//商品代引,
					    checkNull(item.getItemCondition()),//商品の状態,
					    checkNull(subItemForItem.getItemSubcondition()),//商品の状態備考,
					    checkNull(itemPolicyForItem.getReturnPolicy()),//返品の可否,
					    checkNull(subItemForItem.getReturnSubpolicy()),//返品の可否備考,
					    checkNull(itemPolicyForItem.getBidderRatingLimit()),//入札者評価制限,
					    checkNull(itemPolicyForItem.getNegativeFeedbackLimit()),//悪い評価の割合での制限,
					    checkNull(itemPolicyForItem.getBidderAuthenticationRequired()),//入札者認証制限,
					    checkNull(itemPolicyForItem.getAutoExtend()),//自動延長,
					    checkNull(itemPolicyForItem.getEarlyClosing()),//早期終了,
					    checkNull(itemPolicyForItem.getNegotiable()),//値下げ交渉,
					    checkNull(itemPolicyForItem.getAutoRelist()),//自動再出品,
					    checkNull(itemPolicyForItem.getAutoDiscount()),//自動値下げ,
					    checkNull(itemPolicyForItem.getAutoDiscountRate()),//自動値下げ価格変更率,
					    checkNull(subItemForItem.getFeaturedAuction()),//注目のオークション,
					    checkNull(subItemForItem.getRecommendedCollection()),//おすすめコレクション,
					    checkNull(subItemForItem.getFixedShippingFee()),//送料固定,
					    checkNull(method1ForItem.getPackageSize()),//荷物の大きさ,
					    checkNull(method1ForItem.getPackageWeight()),//荷物の重量,
					    checkNull(method1ForItem.getNekopos()),//ネコポス,
					    checkNull(method1ForItem.getNekoTakuhaibinCompact()),//ネコ宅急便コンパクト,
					    checkNull(method1ForItem.getNekoTakuhaibin()),//ネコ宅急便,
					    checkNull(method1ForItem.getYuPack()),//ゆうパック,
					    checkNull(method1ForItem.getYuPacketPostMini()),//ゆうパケットポストmini,
					    checkNull(method1ForItem.getYuPacketPlus()),//ゆうパケットプラス,
					    checkNull(method2ForItem.getShippingLeadTime()),//発送までの日数,
					    checkNull(method3ForItem.getShippingMethod1()),//配送方法1,
					    checkNull(method3ForItem.getShippingMethod1Fee()), //配送方法1全国一律価格,
					    checkNull(method3ForItem.getShippingHokkaido1Fee()),//北海道料金1,
					    checkNull(method3ForItem.getShippingOkinawa1Fee()),//縄料金1,
					    checkNull(method3ForItem.getRemoteIsland1Fee()),//離島料金1,
					    checkNull(method3ForItem.getShippingMethod2()),//配送方法2,
					    checkNull(method3ForItem.getShippingMethod2Fee()), //配送方法2全国一律価格,
					    checkNull(method3ForItem.getShippingHokkaido2Fee()),//北海道料金2,
					    checkNull(method3ForItem.getShippingOkinawa2Fee()),//縄料金2,
					    checkNull(method3ForItem.getRemoteIsland2Fee()),//離島料金2,
					    checkNull(method3ForItem.getShippingMethod3()),//配送方法2,
					    checkNull(method3ForItem.getShippingMethod3Fee()), //配送方法2全国一律価格,
					    checkNull(method3ForItem.getShippingHokkaido3Fee()),//北海道料金2,
					    checkNull(method3ForItem.getShippingOkinawa3Fee()),//縄料金2,
					    checkNull(method3ForItem.getRemoteIsland3Fee()),//離島料金2,,
					    checkNull(method3ForItem.getShippingMethod4()),//配送方法4,
					    checkNull(method3ForItem.getShippingMethod4Fee()), //配送方法4全国一律価格,
					    checkNull(method3ForItem.getShippingHokkaido4Fee()),//北海道料金4,
					    checkNull(method3ForItem.getShippingOkinawa4Fee()),//縄料金4,
					    checkNull(method3ForItem.getRemoteIsland4Fee()),//離島料金4,
					    checkNull(method3ForItem.getShippingMethod5()),//配送方法5,
					    checkNull(method3ForItem.getShippingMethod5Fee()), //配送方法5全国一律価格,
					    checkNull(method3ForItem.getShippingHokkaido5Fee()),//北海道料金5,
					    checkNull(method3ForItem.getShippingOkinawa5Fee()),//縄料金5,
					    checkNull(method3ForItem.getRemoteIsland5Fee()),//離島料金5,
					    checkNull(method3ForItem.getShippingMethod6()),//配送方法6,
					    checkNull(method3ForItem.getShippingMethod6Fee()), //配送方法6全国一律価格,
					    checkNull(method3ForItem.getShippingHokkaido6Fee()),//北海道料金6,
					    checkNull(method3ForItem.getShippingOkinawa6Fee()),//縄料金6,
					    checkNull(method3ForItem.getRemoteIsland6Fee()),//離島料金6,
					    checkNull(method3ForItem.getShippingMethod7()),//配送方法7,
					    checkNull(method3ForItem.getShippingMethod7Fee()), //配送方法7全国一律価格,
					    checkNull(method3ForItem.getShippingHokkaido7Fee()),//北海道料金7,
					    checkNull(method3ForItem.getShippingOkinawa7Fee()),//縄料金7,
					    checkNull(method3ForItem.getRemoteIsland7Fee()),//離島料金7,
					    checkNull(method3ForItem.getShippingMethod8()),//配送方法8,
					    checkNull(method3ForItem.getShippingMethod8Fee()), //配送方法8全国一律価格,
					    checkNull(method3ForItem.getShippingHokkaido8Fee()),//北海道料金8,
					    checkNull(method3ForItem.getShippingOkinawa8Fee()),//縄料金8,
					    checkNull(method3ForItem.getRemoteIsland8Fee()),//離島料金8,
					    checkNull(method3ForItem.getShippingMethod9()),//配送方法9,
					    checkNull(method3ForItem.getShippingMethod9Fee()), //配送方法9全国一律価格,
					    checkNull(method3ForItem.getShippingHokkaido9Fee()),//北海道料金9,
					    checkNull(method3ForItem.getShippingOkinawa9Fee()),//縄料金9,
					    checkNull(method3ForItem.getRemoteIsland9Fee()),//離島料金9,
					    checkNull(method3ForItem.getShippingMethod10()),//配送方法10,
					    checkNull(method3ForItem.getShippingMethod10Fee()), //配送方法10全国一律価格,
					    checkNull(method3ForItem.getShippingHokkaido10Fee()),//北海道料金10,
					    checkNull(method3ForItem.getShippingOkinawa10Fee()),//縄料金10,
					    checkNull(method3ForItem.getRemoteIsland10Fee()),//離島料金10,
					    checkNull(method3ForItem.getPostDeliveryPaymentService()),//受け取り後決済サービス,
					    checkNull(method3ForItem.getInternationalShipping())//海外発送
				};
				
				writer.writeNext(data);
			}
		} catch (IOException e) {
			System.out.println("error!");
			e.printStackTrace();
		}
	}

}
