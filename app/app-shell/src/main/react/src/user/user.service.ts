import { internalize, User } from './user.model';
import { host } from '../configuration/environment';

export const getUsers = (): Promise<User[]> =>
  fetch(`${host}/users`)
    .then((it) => it.json())
    .then((it) => it.map(internalize));
