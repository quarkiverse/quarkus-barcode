<div align="center">
  <div style="display: flex; align-items: center; justify-content: center; gap: 8px;">
    <img src="https://raw.githubusercontent.com/quarkiverse/.github/main/assets/images/quarkus.svg" alt="Quarkus logo" style="height: 70px; width: auto;">
    <img src="https://raw.githubusercontent.com/quarkiverse/.github/main/assets/images/plus-sign.svg" alt="Plus sign" style="height: 70px; width: auto;">
    <img src="https://raw.githubusercontent.com/quarkiverse/quarkus-barcode/main/docs/modules/ROOT/assets/images/qrcode.svg" alt="Barcode logo" style="height: 70px; width: auto;">
  </div>

  <h1>Quarkus Barcode</h1>
</div>
<br>

[![Version](https://img.shields.io/maven-central/v/io.quarkiverse.barcode/quarkus-barcode4j?logo=apache-maven&style=flat-square)](https://search.maven.org/artifact/io.quarkiverse.barcode/quarkus-barcode4j)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg?style=flat-square)](https://opensource.org/licenses/Apache-2.0)
[![Build](https://github.com/quarkiverse/quarkus-barcode/actions/workflows/build.yml/badge.svg)](https://github.com/quarkiverse/quarkus-barcode/actions/workflows/build.yml)

<!-- ALL-CONTRIBUTORS-BADGE:START - Do not remove or modify this section -->
[![All Contributors](https://img.shields.io/badge/all_contributors-5-orange.svg?style=flat-square)](#contributors-)
<!-- ALL-CONTRIBUTORS-BADGE:END -->

## Overview

A Quarkus extension for supporting various barcode libraries in the Quarkus ecosystem and ensuring Native mode is supported.

The following libraries are supported:
- [Okapi](https://github.com/woo-j/OkapiBarcode) comprehensive barcode library used in Quarkus Roq and Quarkus PrimeFaces (v15+)
- [Barcode4J](https://barcode4j.sourceforge.net/) used in Quarkus JasperReports and Quarkus PrimeFaces (v14-)
- [QR Code Generator](https://github.com/nayuki/QR-Code-generator) used in Quarkus PrimeFaces (v14-)
- [Zebra Crossing](https://github.com/zxing/zxing) used in Quarkus Renarde, Quarkus QR

> [!NOTE]
> The main purpose of this extension is to make these libraries work in a native executable built with GraalVM/Mandrel.

## Getting started

* Create or use an existing Quarkus application
* Add the specific extension(s) you need [Quarkus CLI](https://quarkus.io/guides/cli-tooling):

```bash
quarkus ext add io.quarkiverse.barcode:quarkus-barcode4j
quarkus ext add io.quarkiverse.barcode:quarkus-okapi
quarkus ext add io.quarkiverse.barcode:quarkus-qrcodegen
quarkus ext add io.quarkiverse.barcode:quarkus-zxing
```
## Contributors ✨

Thanks goes to these wonderful people ([emoji key](https://allcontributors.org/docs/en/emoji-key)):

<!-- ALL-CONTRIBUTORS-LIST:START - Do not remove or modify this section -->
<!-- prettier-ignore-start -->
<!-- markdownlint-disable -->
<table>
  <tbody>
    <tr>
      <td align="center" valign="top" width="14.28%"><a href="https://melloware.com"><img src="https://avatars.githubusercontent.com/u/4399574?v=4?s=100" width="100px;" alt="Melloware"/><br /><sub><b>Melloware</b></sub></a><br /><a href="#maintenance-melloware" title="Maintenance">🚧</a></td>
      <td align="center" valign="top" width="14.28%"><a href="https://turing85.github.io"><img src="https://avatars.githubusercontent.com/u/32584495?v=4?s=100" width="100px;" alt="Marco Bungart"/><br /><sub><b>Marco Bungart</b></sub></a><br /><a href="#maintenance-turing85" title="Maintenance">🚧</a> <a href="https://github.com/quarkiverse/quarkus-barcode/commits?author=turing85" title="Tests">⚠️</a></td>
      <td align="center" valign="top" width="14.28%"><a href="http://stephane.epardaud.fr"><img src="https://avatars.githubusercontent.com/u/179265?v=4?s=100" width="100px;" alt="Stéphane Épardaud"/><br /><sub><b>Stéphane Épardaud</b></sub></a><br /><a href="#maintenance-FroMage" title="Maintenance">🚧</a> <a href="https://github.com/quarkiverse/quarkus-barcode/commits?author=FroMage" title="Tests">⚠️</a></td>
      <td align="center" valign="top" width="14.28%"><a href="https://github.com/gastaldi"><img src="https://avatars.githubusercontent.com/u/54133?v=4?s=100" width="100px;" alt="George Gastaldi"/><br /><sub><b>George Gastaldi</b></sub></a><br /><a href="#infra-gastaldi" title="Infrastructure (Hosting, Build-Tools, etc)">🚇</a></td>
      <td align="center" valign="top" width="14.28%"><a href="https://github.com/kauanmocelin"><img src="https://avatars.githubusercontent.com/u/3020794?v=4?s=100" width="100px;" alt="Kauan Mocelin"/><br /><sub><b>Kauan Mocelin</b></sub></a><br /><a href="https://github.com/quarkiverse/quarkus-barcode/commits?author=kauanmocelin" title="Documentation">📖</a></td>
    </tr>
  </tbody>
</table>

<!-- markdownlint-restore -->
<!-- prettier-ignore-end -->

<!-- ALL-CONTRIBUTORS-LIST:END -->

This project follows the [all-contributors](https://github.com/all-contributors/all-contributors) specification. Contributions of any kind welcome!
