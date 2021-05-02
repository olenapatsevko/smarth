package tef.smarth.service.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tef.smarth.api.spooncalcular.SpoonCalcularClient;
import tef.smarth.api.spooncalcular.response.MenuResponse;
import tef.smarth.api.spooncalcular.response.SpoonRecipeSummary;
import tef.smarth.model.Menu;
import tef.smarth.service.api.SpoonService;

@Service
public class SpoonServiceImpl implements SpoonService {

    @Autowired
    SpoonCalcularClient spoonCalcularClient;

    @Override
    public MenuResponse getMenu(Menu menu) {
        return spoonCalcularClient.getMenu(menu);
    }

    @Override
    public SpoonRecipeSummary getRecipe(int id) {
        return spoonCalcularClient.getRecipe(id);
    }
}
