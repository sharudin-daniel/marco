package com.example.marco.adapter.grpc;

import dsharudin.marco_polo.grpc.MarcoPolo;
import dsharudin.marco_polo.grpc.MarcoPoloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PoloServiceCall {
    private ManagedChannel channel;

    public MarcoPolo.PoloResponse getPoloGrpc(String marco) {
        try {
            channel = ManagedChannelBuilder.forAddress("polo", 9090)
                    .usePlaintext()
                    .build();
            var stub = MarcoPoloServiceGrpc.newBlockingStub(channel);

            var request = MarcoPolo.MarcoRequest.newBuilder()
                    .setName(marco)
                    .build();
            var resp = stub.getPolo(request);
            System.out.println(resp);
            channel.shutdownNow();
            return resp;
        } catch (StatusRuntimeException e) {
            System.err.println("RPC failed: " + e.getStatus());
            return null;
        }
    }
}
