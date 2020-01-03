export type Listener = ([]) => []

const protocol = 'http';
const baseUrl = 'localhost';
const port = '3000';

export abstract class Service {

  private url: string;
  private listeners: Listener[] = [];

  protected constructor(path: string) {
    this.url = `${protocol}://${baseUrl}:${port}/${path}`;
  }

  protected trigger(): void {
    fetch(this.url, { method: 'GET' })
      .then(it => it.json())
      .then(it => this.updateListeners(it));
  }

  register(listener: Listener): () => void {
    this.listeners = [...this.listeners, listener];
    return () => {
      this.listeners = this.listeners.filter(it => it !== listener);
    };
  }

  private updateListeners(data: any) {
    this.listeners.forEach(it => it(data));
  }

}
