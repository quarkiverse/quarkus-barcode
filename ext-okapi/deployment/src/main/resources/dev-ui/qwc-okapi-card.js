import { pages } from 'build-time-data';
import { LitElement, css, html } from 'lit';
import 'qwc/qwc-extension-link.js';

const NAME = "Okapi Barcode";
export class QwcOkapiCard extends LitElement {

  static styles = css`
      .identity {
        display: flex;
        justify-content: flex-start;
      }

      .description {
        padding-bottom: 10px;
      }

      .logo {
        padding-bottom: 10px;
        margin-right: 5px;
      }

      .card-content {
        color: var(--lumo-contrast-90pct);
        display: flex;
        flex-direction: column;
        justify-content: flex-start;
        padding: 2px 2px;
        height: 100%;
      }

      .card-content slot {
        display: flex;
        flex-flow: column wrap;
        padding-top: 5px;
      }
    `;

  static properties = {
    description: { type: String }
  };

  constructor() {
    super();
  }

  connectedCallback() {
    super.connectedCallback();
  }

  render() {
    return html`<div class="card-content" slot="content">
            <div class="identity">
                <div class="logo">
                    <img src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+CjwhLS0gQ3JlYXRlZCB3aXRoIElua3NjYXBlIChodHRwOi8vd3d3Lmlua3NjYXBlLm9yZy8pIC0tPgoKPHN2ZwogICB4bWxuczpkYz0iaHR0cDovL3B1cmwub3JnL2RjL2VsZW1lbnRzLzEuMS8iCiAgIHhtbG5zOmNjPSJodHRwOi8vY3JlYXRpdmVjb21tb25zLm9yZy9ucyMiCiAgIHhtbG5zOnJkZj0iaHR0cDovL3d3dy53My5vcmcvMTk5OS8wMi8yMi1yZGYtc3ludGF4LW5zIyIKICAgeG1sbnM6c3ZnPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIKICAgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIgogICB2ZXJzaW9uPSIxLjEiCiAgIHdpZHRoPSIzNjgiCiAgIGhlaWdodD0iMzY4IgogICBpZD0ic3ZnODgyMiI+CiAgPG1ldGFkYXRhCiAgICAgaWQ9Im1ldGFkYXRhOTMwOCI+CiAgICA8cmRmOlJERj4KICAgICAgPGNjOldvcmsKICAgICAgICAgcmRmOmFib3V0PSIiPgogICAgICAgIDxkYzpmb3JtYXQ+aW1hZ2Uvc3ZnK3htbDwvZGM6Zm9ybWF0PgogICAgICAgIDxkYzp0eXBlCiAgICAgICAgICAgcmRmOnJlc291cmNlPSJodHRwOi8vcHVybC5vcmcvZGMvZGNtaXR5cGUvU3RpbGxJbWFnZSIgLz4KICAgICAgICA8ZGM6dGl0bGU+PC9kYzp0aXRsZT4KICAgICAgPC9jYzpXb3JrPgogICAgPC9yZGY6UkRGPgogIDwvbWV0YWRhdGE+CiAgPGRlZnMKICAgICBpZD0iZGVmczkzMDYiIC8+CiAgPHBhdGgKICAgICBkPSJtIDE2LDE2IDAsMTYgMCwxNiAwLDE2IDAsMTYgMCwxNiAwLDE2IDAsMTYgMTYsMCAxNiwwIDE2LDAgMTYsMCAxNiwwIDE2LDAgMTYsMCAwLC0xNiAwLC0xNiAwLC0xNiAwLC0xNiAwLC0xNiAwLC0xNiAwLC0xNiAtMTYsMCAtMTYsMCAtMTYsMCAtMTYsMCAtMTYsMCAtMTYsMCAtMTYsMCB6IG0gMTI4LDAgMCwxNiAwLDE2IDE2LDAgMCwtMTYgMTYsMCAwLC0xNiAtMTYsMCAtMTYsMCB6IG0gMzIsMTYgMCwxNiAxNiwwIDAsLTE2IC0xNiwwIHogbSAxNiwxNiAwLDE2IDE2LDAgMTYsMCAwLC0xNiAwLC0xNiAwLC0xNiAtMTYsMCAwLDE2IDAsMTYgLTE2LDAgeiBtIDAsMTYgLTE2LDAgLTE2LDAgLTE2LDAgMCwxNiAxNiwwIDE2LDAgMCwxNiAtMTYsMCAwLDE2IDE2LDAgMCwxNiAxNiwwIDAsLTE2IDE2LDAgMCwxNiAtMTYsMCAwLDE2IC0xNiwwIDAsMTYgMTYsMCAxNiwwIDAsMTYgMTYsMCAwLC0xNiAwLC0xNiAwLC0xNiAwLC0xNiAwLC0xNiAtMTYsMCAwLC0xNiAtMTYsMCAwLC0xNiB6IG0gMTYsMTEyIC0xNiwwIDAsMTYgLTE2LDAgMCwxNiAwLDE2IDE2LDAgMCwxNiAwLDE2IC0xNiwwIC0xNiwwIDAsLTE2IDE2LDAgMCwtMTYgLTE2LDAgMCwtMTYgMCwtMTYgLTE2LDAgMCwtMTYgMTYsMCAwLDE2IDE2LDAgMCwtMTYgMCwtMTYgLTE2LDAgLTE2LDAgMCwtMTYgLTE2LDAgLTE2LDAgLTE2LDAgMCwxNiAtMTYsMCAwLDE2IC0xNiwwIDAsLTE2IDE2LDAgMCwtMTYgLTE2LDAgLTE2LDAgMCwxNiAtMTYsMCAwLDE2IDAsMTYgMCwxNiAxNiwwIDAsLTE2IDE2LDAgMTYsMCAxNiwwIDAsLTE2IDE2LDAgMCwtMTYgMTYsMCAwLDE2IC0xNiwwIDAsMTYgMTYsMCAwLDE2IC0xNiwwIDAsMTYgMTYsMCAxNiwwIDAsMTYgMCwxNiAwLDE2IDE2LDAgMCwxNiAxNiwwIDE2LDAgMTYsMCAwLDE2IC0xNiwwIC0xNiwwIC0xNiwwIDAsLTE2IC0xNiwwIDAsMTYgMCwxNiAxNiwwIDAsMTYgLTE2LDAgMCwxNiAxNiwwIDE2LDAgMCwtMTYgMTYsMCAwLDE2IDE2LDAgMTYsMCAxNiwwIDE2LDAgMCwtMTYgMTYsMCAwLDE2IDE2LDAgMTYsMCAxNiwwIDAsLTE2IC0xNiwwIC0xNiwwIDAsLTE2IC0xNiwwIDAsLTE2IC0xNiwwIDAsMTYgLTE2LDAgLTE2LDAgMCwxNiAtMTYsMCAwLC0xNiAxNiwwIDAsLTE2IDAsLTE2IDAsLTE2IDE2LDAgMCwtMTYgLTE2LDAgLTE2LDAgMCwtMTYgMTYsMCAwLC0xNiAwLC0xNiAwLC0xNiAtMTYsMCAwLC0xNiB6IG0gNDgsMTI4IDAsLTE2IC0xNiwwIDAsMTYgMTYsMCB6IG0gMzIsMTYgMTYsMCAxNiwwIDAsLTE2IC0xNiwwIC0xNiwwIDAsMTYgeiBtIDMyLC0xNiAxNiwwIDAsLTE2IDAsLTE2IDAsLTE2IDAsLTE2IC0xNiwwIC0xNiwwIC0xNiwwIDAsLTE2IC0xNiwwIDAsMTYgLTE2LDAgMCwxNiAwLDE2IDE2LDAgMCwtMTYgMTYsMCAwLDE2IDAsMTYgMTYsMCAxNiwwIDAsMTYgeiBtIC00OCwtODAgMCwtMTYgLTE2LDAgLTE2LDAgMCwxNiAxNiwwIDE2LDAgeiBtIDE2LDAgMTYsMCAwLC0xNiAwLC0xNiAwLC0xNiAxNiwwIDAsMTYgMTYsMCAwLDE2IDE2LDAgMCwtMTYgMCwtMTYgLTE2LDAgMCwtMTYgMTYsMCAwLC0xNiAtMTYsMCAtMTYsMCAwLDE2IC0xNiwwIDAsLTE2IC0xNiwwIDAsMTYgLTE2LDAgMCwxNiAxNiwwIDAsMTYgMCwxNiAwLDE2IHogbSAtMTYsLTQ4IC0xNiwwIDAsMTYgMTYsMCAwLC0xNiB6IG0gNjQsMzIgLTE2LDAgMCwxNiAxNiwwIDAsLTE2IHogbSAtMjI0LDAgMCwtMTYgLTE2LDAgMCwxNiAxNiwwIHogbSAtMTYsMCAtMTYsMCAtMTYsMCAtMTYsMCAwLDE2IDE2LDAgMTYsMCAxNiwwIDAsLTE2IHogbSAtNjQsMCAtMTYsMCAwLDE2IDE2LDAgMCwtMTYgeiBtIDAsLTQ4IDAsLTE2IC0xNiwwIDAsMTYgMTYsMCB6IG0gMTEyLC0xNiAxNiwwIDAsLTE2IDAsLTE2IC0xNiwwIDAsMTYgMCwxNiB6IG0gOTYsLTEyOCAwLDE2IDAsMTYgMCwxNiAwLDE2IDAsMTYgMCwxNiAwLDE2IDE2LDAgMTYsMCAxNiwwIDE2LDAgMTYsMCAxNiwwIDE2LDAgMCwtMTYgMCwtMTYgMCwtMTYgMCwtMTYgMCwtMTYgMCwtMTYgMCwtMTYgLTE2LDAgLTE2LDAgLTE2LDAgLTE2LDAgLTE2LDAgLTE2LDAgLTE2LDAgeiBtIC0yMDgsMTYgMTYsMCAxNiwwIDE2LDAgMTYsMCAxNiwwIDAsMTYgMCwxNiAwLDE2IDAsMTYgMCwxNiAtMTYsMCAtMTYsMCAtMTYsMCAtMTYsMCAtMTYsMCAwLC0xNiAwLC0xNiAwLC0xNiAwLC0xNiAwLC0xNiB6IG0gMjI0LDAgMTYsMCAxNiwwIDE2LDAgMTYsMCAxNiwwIDAsMTYgMCwxNiAwLDE2IDAsMTYgMCwxNiAtMTYsMCAtMTYsMCAtMTYsMCAtMTYsMCAtMTYsMCAwLC0xNiAwLC0xNiAwLC0xNiAwLC0xNiAwLC0xNiB6IG0gLTIwOCwxNiAwLDE2IDAsMTYgMCwxNiAxNiwwIDE2LDAgMTYsMCAwLC0xNiAwLC0xNiAwLC0xNiAtMTYsMCAtMTYsMCAtMTYsMCB6IG0gMjI0LDAgMCwxNiAwLDE2IDAsMTYgMTYsMCAxNiwwIDE2LDAgMCwtMTYgMCwtMTYgMCwtMTYgLTE2LDAgLTE2LDAgLTE2LDAgeiBtIC0zMiw5NiAwLDE2IDE2LDAgMCwtMTYgLTE2LDAgeiBtIC0yMjQsOTYgMCwxNiAwLDE2IDAsMTYgMCwxNiAwLDE2IDAsMTYgMCwxNiAxNiwwIDE2LDAgMTYsMCAxNiwwIDE2LDAgMTYsMCAxNiwwIDAsLTE2IDAsLTE2IDAsLTE2IDAsLTE2IDAsLTE2IDAsLTE2IDAsLTE2IC0xNiwwIC0xNiwwIC0xNiwwIC0xNiwwIC0xNiwwIC0xNiwwIC0xNiwwIHogbSAxNiwxNiAxNiwwIDE2LDAgMTYsMCAxNiwwIDE2LDAgMCwxNiAwLDE2IDAsMTYgMCwxNiAwLDE2IC0xNiwwIC0xNiwwIC0xNiwwIC0xNiwwIC0xNiwwIDAsLTE2IDAsLTE2IDAsLTE2IDAsLTE2IDAsLTE2IHogbSAxNiwxNiAwLDE2IDAsMTYgMCwxNiAxNiwwIDE2LDAgMTYsMCAwLC0xNiAwLC0xNiAwLC0xNiAtMTYsMCAtMTYsMCAtMTYsMCB6IG0gMjg4LDQ4IDAsMTYgMTYsMCAwLC0xNiAtMTYsMCB6IgogICAgIGlkPSJwYXRoMzA5MyIKICAgICBzdHlsZT0iZmlsbDojMDAwMDAwO3N0cm9rZTpub25lIiAvPgo8L3N2Zz4K"
                                       alt="${NAME}" 
                                       title="${NAME}"
                                       width="32" 
                                       height="32">
                </div>
                <div class="description">${this.description}</div>
            </div>
            ${this._renderCardLinks()}
        </div>
        `;
  }

  _renderCardLinks() {
    return html`${pages.map(page => html`
                            <qwc-extension-link slot="link"
                                extensionName="${NAME}"
                                iconName="${page.icon}"
                                displayName="${page.title}"
                                staticLabel="${page.staticLabel}"
                                dynamicLabel="${page.dynamicLabel}"
                                streamingLabel="${page.streamingLabel}"
                                path="${page.id}"
                                ?embed=${page.embed}
                                externalUrl="${page.metadata.externalUrl}"
                                webcomponent="${page.componentLink}" >
                            </qwc-extension-link>
                        `)}`;
  }

}
customElements.define('qwc-okapi-card', QwcOkapiCard);