#!/usr/bin/env bash
set -e
for port in 8081 8082 8083 8084 8085; do
  echo "Checking $port"
  curl -fsS "http://localhost:$port/api/v1/health"
  echo
done
