import { Service } from './AbstractService';
import { Listener } from '../models';

class UserService extends Service {
  constructor() {
    super('users');
  }

  register = (listener: Listener) => {
    const block = super.register(listener);
    super.trigger();
    return block;
  };
}

const userServiceInstance = new UserService();

export const userService = userServiceInstance;
