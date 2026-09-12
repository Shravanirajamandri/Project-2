#!/bin/bash
set -euo pipefail
cd "$(dirname "$0")/.."
mvn -B clean package
