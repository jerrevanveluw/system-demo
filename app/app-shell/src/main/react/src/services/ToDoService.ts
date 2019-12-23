import { Listener, Service } from './AbstractService';

class ToDoService extends Service {

  constructor() {
    super('todos');
  }

  register = (listener: Listener) => {
    const block = super.register(listener);
    super.trigger();
    return block;
  };

}

const toDoServiceInstance = new ToDoService();

export const toDoService = toDoServiceInstance;
