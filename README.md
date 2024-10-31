<div align="center">
<img src="https://github.com/quarkiverse/.github/blob/main/assets/images/quarkus.svg" width="67" height="70" ><img src="https://github.com/quarkiverse/.github/blob/main/assets/images/plus-sign.svg" height="70" ><img src="https://github.com/quarkiverse/quarkus-barcode/blob/main/docs/modules/ROOT/assets/images/qrcode.svg" height="70" >

# Quarkus Barcode
</div>
<br>

[![Version](https://img.shields.io/maven-central/v/io.quarkiverse.barcode/quarkus-barcode?logo=apache-maven&style=flat-square)](https://search.maven.org/artifact/io.quarkiverse.barcode/quarkus-barcode)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg?style=flat-square)](https://opensource.org/licenses/Apache-2.0)
[![Build](https://github.com/quarkiverse/quarkus-barcode/actions/workflows/build.yml/badge.svg)](https://github.com/quarkiverse/quarkus-barcode/actions/workflows/build.yml)


## Overview

A Quarkus extension for supporting various barcode libraries in the Quarkus ecosystem and ensuring Native mode is supported.

The following libraries are supported:
- [Barcode4J](https://barcode4j.sourceforge.net/) used in Quarkus PrimeFaces/JasperReports
- [Okapi](https://github.com/woo-j/OkapiBarcode) comprehensive barcode library
- [QR Code Generator](https://github.com/nayuki/QR-Code-generator) used in Quarkus PrimeFaces
- [Zebra Crossing](https://github.com/zxing/zxing) used in Quarkus Rendarde

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