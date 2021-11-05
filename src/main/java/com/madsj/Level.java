package com.madsj;

import com.madsj.exception.MalformedCommandException;
import com.madsj.exception.UnknownCommandException;
import com.madsj.exception.WrongNumberOfArgumentsException;
import com.madsj.item.description.StorageItemDescription;
import com.madsj.item.instance.ItemInstance;
import com.madsj.item.instance.StorageItemInstance;
import com.madsj.response.CommandListResponse;
import com.madsj.response.DescribeStorageResponse;
import com.madsj.response.ErrorResponse;
import com.madsj.response.Response;

import java.util.HashMap;
import java.util.Map;

public class Level {

    public void setup() {
        LevelObjects.getItemDB().add(new StorageItemDescription("Chest", 10));
        StorageItemInstance storage = (StorageItemInstance)LevelObjects.getItemDB().getByName("Chest").createInstance();
        new DescribeStorageResponse(storage).print();
    }

    public void play() {
        Command lastCommand = new Command("nil");

        do {
            //Get next command from user
            try {
                lastCommand = Input.nextCommand();
                Response response = processCommand(lastCommand);
                response.print();
            } catch (UnknownCommandException | MalformedCommandException | WrongNumberOfArgumentsException e) {
                ErrorResponse response = new ErrorResponse(e);
                response.print();
            }

        } while (!lastCommand.getOperation().equals(Command.QUIT));
    }

    private Response processCommand(Command command) {
        if (command.getOperation().equals(Command.HELP)) {
            return new CommandListResponse();
        }
        return null;
    }
}
