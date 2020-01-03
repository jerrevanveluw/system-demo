import { Listener, Service } from './AbstractService';

class TodoService extends Service {

  constructor() {
    super('todos');
  }

  register = (listener: Listener) => {
    const block = super.register(listener);
    super.trigger();
    return block;
  };

}

const todoServiceInstance = new TodoService();

export const todoService = todoServiceInstance;
