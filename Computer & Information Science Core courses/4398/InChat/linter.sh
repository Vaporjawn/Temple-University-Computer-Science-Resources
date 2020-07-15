#!/bin/bash

# Linting of source files for GCP Firebase functions
eslint functions/index.js

# Linting of typescript files in src/
eslint src/app/ --ext .ts
