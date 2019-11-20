package local.address.filter;

import com.github.houbb.opencc4j.util.ZhConverterUtil;

/**
 * @author cuixiaoshuang
 * @date 2019-11-19
 **/
public class SimpleChineseCharacterFilter implements CharacterFilter {

    @Override
    public String filter(String origin) {
        return ZhConverterUtil.convertToSimple(origin);
    }
}
