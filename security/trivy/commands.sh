#!/usr/bin/env bash
set -e
trivy fs --severity HIGH,CRITICAL .
trivy image --severity HIGH,CRITICAL customer-service:1.0
