#!/bin/sh

# Wait for Redis nodes to be ready
sleep 15

echo "Creating Redis Cluster..."
redis-cli --cluster create \
  127.0.0.1:7001 \
  127.0.0.1:7002 \
  127.0.0.1:7003 \
  127.0.0.1:7101 \
  127.0.0.1:7102 \
  127.0.0.1:7103 \
  --cluster-replicas 1 \
  --cluster-yes

echo "Redis Cluster initialization completed!"
