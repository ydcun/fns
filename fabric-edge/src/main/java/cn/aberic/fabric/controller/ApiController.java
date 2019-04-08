package cn.aberic.fabric.controller;


import cn.aberic.fabric.bean.*;
import cn.aberic.fabric.dao.entity.App;
import cn.aberic.fabric.service.ApiService;
import cn.aberic.fabric.service.AppService;
import cn.aberic.fabric.utils.SpringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("api")
public class ApiController {

    @Autowired
    private ApiService apiService;

    //厂商
    private static List<IctFirm> ictFirmList = new ArrayList<IctFirm>();
    //供销商
    private static List<IctVendors> ictVendors = new ArrayList<IctVendors>();
    //售后
    private static List<IctCs> ictCs = new ArrayList<IctCs>();
    //设备
    private static List<IctGoods> ictGoods = new ArrayList<IctGoods>();
    //交易
    private static List<IctGetInfo> ictGetInfos = new ArrayList<IctGetInfo>();
    private ApiController(){
        ictFirmList.add(new IctFirm("1","极动云平台","expeedcloud"));
        ictFirmList.add(new IctFirm("2","海尔","Haier"));
        ictFirmList.add(new IctFirm("3","佳能","Ganon"));
        ictFirmList.add(new IctFirm("4","夏普","SHARP"));
        ictFirmList.add(new IctFirm("5","索尼","SONY"));
        ictFirmList.add(new IctFirm("6","三星","SAMSUNG"));
        ictFirmList.add(new IctFirm("7","海信","Hisense"));
        ictFirmList.add(new IctFirm("8","飞利浦","PHILIP"));
        ictFirmList.add(new IctFirm("9","康佳","KONKA"));
        ictFirmList.add(new IctFirm("10","格力","GREEN"));
        ictFirmList.add(new IctFirm("11","小米","MI"));

        ictVendors.add(new IctVendors("12","淘宝","taobao"));
        ictVendors.add(new IctVendors("13","京东","jd"));
        ictVendors.add(new IctVendors("14","苏宁","Suning"));
        ictVendors.add(new IctVendors("15","拼多多","PDD"));

        ictCs.add(new IctCs("20","北京中关村大厦家电设备4S店","4SONE"));
        ictCs.add(new IctCs("21","北京国美4S店","GOMEI4S"));
        ictCs.add(new IctCs("22","北京国贸小米4S","MI4S"));
        ictCs.add(new IctCs("23","杭州家电设备4S店","HZ4S"));

        ictGoods.add(new IctGoods("1","数码产品","smcp","EOS 80D 单反套机","624349dd88c7faf8da93e21a1a1e9230","待售","2019-03-01 22:10:03","3","3","12"));
        ictGoods.add(new IctGoods("2","厨卫电器","cwdq","海尔EC6004-JRS热水器","b7a1377eb5c6292922091a92a764c1d4","待售","2019-03-01 22:10:03","2","2","12"));
        ictGoods.add(new IctGoods("3","环境电器","hjdq","智米SMARTMI","8cfeb52362ca64aaf26faf498805e178","待售","2019-03-01 22:10:03","11","11","12"));
        ictGoods.add(new IctGoods("4","小家电","xjd","康佳电磁炉","0ca3fb59282a070c0c85e9f721a9f2d1","待售","2019-03-01 22:10:03","9","9","13"));
        ictGoods.add(new IctGoods("5","大家电","djs","小米电视L55M5-AD","269d826e6d5ded644e22b81039098adc","待售","2019-03-01 22:10:03","11","11","14"));

        ictGetInfos.add(new IctGetInfo("4d82788f30965d51ebe1347c42625b3eda9298367d4a739ae9e5fb4d5d38ef7b","1","Ganon","Joa","2019-03-01 10:10:20"));
    }

    /**
     * 厂商列表
     * @return
     *        {
     *             size: 2,
     *             list:[
     *                 {
     *                     userId: string 厂商用户id
     *                     name: string 厂商名称
     *                     code: string 厂商code
     *                 },
     *                 {
     *                     ...
     *                 }
     *             ]
     *         }
     */
    @GetMapping(value = "firm.ajax")
    @ResponseBody
    public Map<String,Object> firm() {

        Map<String, Object> map = new HashMap<>();
        map.put("size",ictFirmList.size());
        map.put("list",ictFirmList);
        return map;
    }
    /**
     * 供销商列表
     * @return
     *        {
     *             size: 2
     *             list:[
     *                 {
     *                     userId: string 供销商id
     *                     name: string 供销商名
     *                     code: string 供销商code
     *                 },
     *                 {
     *                     ...
     *                 }
     *             ]
     *         }
     */
    @GetMapping(value = "vendors.ajax")
    @ResponseBody
    public Map<String, Object> vendors() {

        Map<String, Object> map = new HashMap<>();
        map.put("size",ictVendors.size());
        map.put("list",ictVendors);
        return map;
    }

    /**
     * 售后列表
     * @param businessId
     * @return
     *        {
     *             size: 2
     *             list:[
     *                 {
     *                     userId: string 售后id
     *                     name: string 售后名
     *                     code: string 售后code
     *                 },
     *                 {
     *                     ...
     *                 }
     *             ]
     *         }
     */
    @GetMapping(value = "cs.ajax")
    @ResponseBody
    public Map<String, Object> cs(@RequestParam("businessId") Integer businessId) {

        Map<String, Object> map = new HashMap<>();
        map.put("size",ictCs.size());
        map.put("list",ictCs);
        return map;
    }
    /**
     * 查询厂商/供销商/售后/用户物品列表信息
     * @return
     *         {
     *             size: 2,
     *             list:[
     *                 {
     *                     id: string 商品id
     *                     className: string "电冰箱" 类别名称
     *                     classCode: string "refrigerator" 类别名称code
     *                     name: string "Haier/海尔 双门冰箱对开门 576升 风冷无霜除味变频家用保鲜电冰箱 BCD-576WDPU"
     *                     code: string "Haier BCD-576WDPU"
     *                     status: string 售出、待售、使用中、待维修
     *                     createDate: string "2019-03-01 22:10:03" 最后交易时间
     *                     userId: 用户id aaac6f9c9970b855
     *                     venderId：厂商id
     *                     supplierId：供销商id
     *                 },
     *                 {
     *                     ...
     *                 }
     *             ]
     *         }
     */
    @GetMapping(value = "goodsList.ajax")
    @ResponseBody
    public Map<String, Object> goodsList(@RequestParam("id") Integer id) {

        Map<String, Object> map = new HashMap<>();
        List<IctGoods> list = new ArrayList<>();
        for (IctGoods ictGood : ictGoods) {
            if(ictGood.getUserId().equals(id)
                    || ictGood.getVenderId().equals(id)
                    || ictGood.getSupplierId().equals(id)){
                list.add(ictGood);
            }
        }
        map.put("size",list.size());
        map.put("list",list);
        return map;
    }
    /**
     * 查询物品交易信息列表
     * @return
     *        {
     *             size: 2,
     *             list: [
     *                 {
     *                     hash: string 4d82788f30965d51ebe1347c42625b3eda9298367d4a739ae9e5fb4d5d38ef7b 交易hash
     *                     id: String 商品id
     *                     fromUserName:
     *                     toUserName:
     *                     createDate: string "2019-03-01 22:10:03" 交易时间
     *                 },
     *                 {
     *                     ...
     *                 }
     *             ]
     *         }
     */
    @GetMapping(value = "getInfoAll.ajax")
    @ResponseBody
    public Map<String,Object> getInfoAll(@RequestParam("id") Integer id) {

        Map<String, Object> map = new HashMap<>();
        List<IctGetInfo> list = new ArrayList<>();
        for (IctGetInfo ictGetInfo : ictGetInfos) {
            if(ictGetInfo.getId().equals(id)){
                list.add(ictGetInfo);
            }
        }
        map.put("size",list.size());
        map.put("list",list);
        return map;
    }
}
