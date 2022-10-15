package com.personaldb.endpoints;

import com.personaldb.domain.Item;
import com.personaldb.service.ItemService;
import com.personaldb.service.requests.AddRequest;
import com.personaldb.service.requests.RemoveRequest;
import com.personaldb.service.responses.AddResponse;
import com.personaldb.service.responses.GetResponse;
import com.personaldb.service.responses.RemoveResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/item")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public AddResponse addItem(@RequestBody AddRequest request) {

        itemService.addItem(request.name());

        return new AddResponse(OK);
    }

    @PostMapping(value = "/remove", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public RemoveResponse removeItem(@RequestBody RemoveRequest request) {

        itemService.removeItem(request.itemId());

        return new RemoveResponse(OK);
    }

    @GetMapping(value = "/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public GetResponse getItem(@PathVariable("id") String itemId) {

        itemService.removeItem(itemId);

        return new GetResponse(OK, new Item(itemId,"Deneme"));
    }
}
