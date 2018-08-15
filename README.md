### 银行卡 bin 查询
> * 银行卡集信息滞后，需要定时更新，可以先调用系统工具类，在调用阿里接口 https://ccdcapi.alipay.com/validateAndCacheCardInfo.json?_input_charset=utf-8&cardNo=%E9%93%B6%E8%A1%8C%E5%8D%A1%E5%8F%B7&cardBinCheck=true
> * 银行卡校验码校验，存在部分卡不符合校验规则，只做参考