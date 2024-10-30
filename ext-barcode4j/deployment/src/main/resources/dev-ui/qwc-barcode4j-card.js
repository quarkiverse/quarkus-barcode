import { pages } from 'build-time-data';
import { LitElement, css, html } from 'lit';
import 'qwc/qwc-extension-link.js';

const NAME = "Barcode4J";
export class QwcBarcode4JCard extends LitElement {

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
                    <img src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pg0KPCEtLSBVcGxvYWRlZCB0bzogU1ZHIFJlcG8sIHd3dy5zdmdyZXBvLmNvbSwgR2VuZXJhdG9yOiBTVkcgUmVwbyBNaXhlciBUb29scyAtLT4NCjxzdmcgaGVpZ2h0PSI4MDBweCIgd2lkdGg9IjgwMHB4IiB2ZXJzaW9uPSIxLjEiIGlkPSJDYXBhXzEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIA0KCSB2aWV3Qm94PSIwIDAgMTUuMjczIDE1LjI3MyIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+DQo8cmVjdCB3aWR0aD0iMTAwJSIgaGVpZ2h0PSIxMDAlIiBmaWxsPSJ3aGl0ZSIvPg0KPGc+DQoJPHBhdGggc3R5bGU9ImZpbGw6IzAzMDEwNDsiIGQ9Ik0wLDEuODAzaDAuODk3VjEzLjQ3SDBWMS44MDN6IE0xLjQ0NiwxMy40N2gwLjUwNVYxLjgwM0gxLjQ0NlYxMy40N3ogTTIuMzE1LDEzLjQ3aDAuNTA0VjEuODAzDQoJCUgyLjMxNVYxMy40N3ogTTMuNDgyLDEzLjQ3aDEuMTA0VjEuODAzSDMuNDgyVjEzLjQ3eiBNNS40NywxMy40N2gwLjU1MlYxLjgwM0g1LjQ3VjEzLjQ3eiBNNi44NzgsMTMuNDdoMi4yODhWMS44MDNINi44NzhWMTMuNDd6DQoJCSBNMTIuODQsMTMuNDdoMC43NTJWMS44MDNIMTIuODRWMTMuNDd6IE0xNC4yNDgsMS44MDNWMTMuNDdoMS4wMjVWMS44MDNIMTQuMjQ4eiBNMTAuMDg0LDEzLjQ3aDAuNDkyVjEuODAzaC0wLjQ5MlYxMy40N3oNCgkJIE0xMS4yODEsMTMuNDdoMC40OTJWMS44MDNoLTAuNDkyVjEzLjQ3eiIvPg0KPC9nPg0KPC9zdmc+"
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
customElements.define('qwc-barcode4j-card', QwcBarcode4JCard);