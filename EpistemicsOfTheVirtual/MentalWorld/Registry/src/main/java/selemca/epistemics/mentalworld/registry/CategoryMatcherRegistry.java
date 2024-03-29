/*
 * This source file is part of the Epistemics of the Virtual software.
 * It was created by:
 * Johan F. Hoorn - theoretical model and algorithms
 * Henri Zwols - software design and engineering
 */
package selemca.epistemics.mentalworld.registry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import selemca.epistemics.mentalworld.engine.category.CategoryMatcher;
import selemca.epistemics.mentalworld.registry.config.RegistryKey;

import java.util.Map;

@Component
public class CategoryMatcherRegistry extends AbstractPluginRegistry<CategoryMatcher> {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    public CategoryMatcherRegistry(Map<String, CategoryMatcher> implementations) {
        super(RegistryKey.CATEGORY_MATCH_IMPLEMENTATION, CategoryMatcher.class, implementations);
    }
}
