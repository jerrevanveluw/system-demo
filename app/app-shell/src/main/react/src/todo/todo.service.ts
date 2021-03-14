import { internalize, Todo } from './todo.model';
import { host } from '../configuration/environment';

export const getTodos = (): Promise<Todo[]> =>
  fetch(`${host}/todos`)
    .then((it) => it.json())
    .then((it) => it.map(internalize));
