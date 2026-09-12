#!/usr/bin/env bash
set -e
kubectl apply -f kubernetes/namespace.yaml
kubectl apply -f kubernetes/configmap.yaml
kubectl apply -f kubernetes/secret.yaml
kubectl apply -f kubernetes/postgres.yaml
for f in kubernetes/*-service.yaml; do kubectl apply -f "$f"; done
kubectl apply -f kubernetes/hpa.yaml
kubectl apply -f kubernetes/pdb.yaml
kubectl apply -f kubernetes/rbac.yaml
kubectl apply -f kubernetes/resource-quota.yaml
