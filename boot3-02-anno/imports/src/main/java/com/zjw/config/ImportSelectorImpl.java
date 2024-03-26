package com.zjw.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 通过实现ImportSelector接口来实现自定义导入
 * <p>
 * 实际开发中可以把要导入的类放在resources目录下，参考SpringBoot的自动装配机制
 *
 * @author 朱俊伟
 * @since 2024/03/15 14:36
 */
public class ImportSelectorImpl implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.zjw.domain.Cat"};
    }
}
