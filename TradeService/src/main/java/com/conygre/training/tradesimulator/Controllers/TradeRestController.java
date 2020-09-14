package com.conygre.training.tradesimulator.Controllers;

import com.conygre.training.tradesimulator.model.Trade;
import com.conygre.training.tradesimulator.model.TradeState;
import com.conygre.training.tradesimulator.sim.TradeSim;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
public class TradeRestController {

    @Autowired
    TradeSim tradesim;

    @GetMapping("/getTrades")
    public ResponseEntity<List<Trade>> getAllTrades(){
        return ResponseEntity.ok().body(tradesim.findTradesForProcessing());
    }
    @GetMapping("/getTradesByState")
    public ResponseEntity<List<Trade>> getStateTrades(@RequestParam String state){
        return ResponseEntity.ok().body(tradesim.getTradeByState(Arrays.stream(TradeState.values()).filter(t-> t.getState().equals(state)).findFirst().get()));
    }
    @GetMapping("/getTradeById")
    public ResponseEntity<Trade>getTradeById(@RequestParam ObjectId _id){
        return ResponseEntity.ok().body(tradesim.getTrade(_id).get());
    }
    @GetMapping("/getTradeStates")
    public TradeState[] getTradeStates(){
        return  TradeState.values();
    }
}
