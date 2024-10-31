<div align="center">

<img src="https://github.com/quarkiverse/.github/blob/main/assets/images/quarkus.svg" width="67" height="70" ><img src="https://github.com/quarkiverse/.github/blob/main/assets/images/plus-sign.svg" height="70" ><img src="https://github.com/quarkiverse/quarkus-barcode/blob/main/docs/modules/ROOT/assets/images/qrcode.svg" height="70" >

# Quarkus Barcode
</div>
<br>

[![Version](https://img.shields.io/maven-central/v/io.quarkiverse.barcode/quarkus-barcode?logo=apache-maven&style=flat-square)](https://search.maven.org/artifact/io.quarkiverse.barcode/quarkus-barcode)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg?style=flat-square)](https://opensource.org/licenses/Apache-2.0)
[![Build](https://github.com/quarkiverse/quarkus-barcode/actions/workflows/build.yml/badge.svg)](https://github.com/quarkiverse/quarkus-barcode/actions/workflows/build.yml)

<!-- ALL-CONTRIBUTORS-BADGE:START - Do not remove or modify this section -->
[![All Contributors](https://img.shields.io/badge/all_contributors-3-orange.svg?style=flat-square)](#contributors-)
<!-- ALL-CONTRIBUTORS-BADGE:END -->

## Overview

A Quarkus extension for supporting various barcode libraries in the Quarkus ecosystem and ensuring Native mode is supported.

The following libraries are supported:
- [Barcode4J](https://barcode4j.sourceforge.net/) used in Quarkus PrimeFaces/JasperReports
- [Okapi](https://github.com/woo-j/OkapiBarcode) comprehensive barcode library
- [QR Code Generator](https://github.com/nayuki/QR-Code-generator) used in Quarkus PrimeFaces
- [Zebra Crossing](https://github.com/zxing/zxing) used in Quarkus Renarde

> [!NOTE]
> The main purpose of this extension is to make these libraries work in a native executable built with GraalVM/Mandrel.

## Getting started

Read the full [Quarkus Barcode documentation](https://docs.quarkiverse.io/quarkus-barcode/dev/index.html).

### Prerequisite

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
      <td align="center" valign="top" width="14.28%"><a href="https://turing85.github.io"><img src="https://avatars.githubusercontent.com/u/32584495?v=4?s=100" width="100px;" alt="Marco Bungart"/><br /><sub><b>Marco Bungart</b></sub></a><br /><a href="#maintenance-turing85" title="Maintenance">🚧</a></td>
      <td align="center" valign="top" width="14.28%"><a href="http://stephane.epardaud.fr"><img src="https://avatars.githubusercontent.com/u/179265?v=4?s=100" width="100px;" alt="Stéphane Épardaud"/><br /><sub><b>Stéphane Épardaud</b></sub></a><br /><a href="#maintenance-FroMage" title="Maintenance">🚧</a> <a href="https://github.com/quarkiverse/quarkus-barcode/commits?author=FroMage" title="Tests">⚠️</a></td>
    </tr>
  </tbody>
</table>

<!-- markdownlint-restore -->
<!-- prettier-ignore-end -->

<!-- ALL-CONTRIBUTORS-LIST:END -->

This project follows the [all-contributors](https://github.com/all-contributors/all-contributors) specification. Contributions of any kind welcome!
