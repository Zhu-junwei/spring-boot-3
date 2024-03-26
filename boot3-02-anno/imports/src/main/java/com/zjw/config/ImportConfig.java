package com.zjw.config;

import com.zjw.domain.Dog;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 通过Import注解向Spring容器中导入类，默认是类的全类名
 * <p>
 * 可以通过
 *
 * @author 朱俊伟
 * @since 2024/03/15 14:23
 */
@Configuration
@Import({Dog.class, ImportSelectorImpl.class})
public class ImportConfig {
}
