package com.codefans.interview.algorithm.practise;

import com.codefans.reusablecode.datastructure.ListUtils;

import java.util.*;

/**
 * @Author: codefans
 * @Date: 2022-04-02 12:45
 */

public class ReceiverExtractor {

    /**
     * key: 邮件组的id
     * value: 该邮件组的成员，邮件组的成员可能是个人或者另外一个邮件组
     * g1: u1, u2, u3, g2
     * g2: u3, u4, g3
     * g3: u4, u5, u6
     */
    private Map<String, List<String>> groupMap = new HashMap<>(8);
    private Map<String, List<String>> cacheMap = new HashMap<>(8);

    /**
     *
     */
    public ReceiverExtractor() {
        groupMap.put("g1", Arrays.asList("u1", "u2", "u3", "g2"));
        groupMap.put("g2", Arrays.asList("u3", "u4", "g3"));
        groupMap.put("g3", Arrays.asList("u4", "u5", "u6"));
    }

    /**
     * 用户输入的收件人列表receivers, eg: g1, u2, g2, u3, g3, u7
     * return实际需要送达的收件人列表, eg: u1, u2, u3, u4, u5, u6, u7
     * @param receivers
     * @return
     */
    public List<String> getUsers(List<String> receivers) {
        List<String> resultList = new ArrayList<>(8);
        getUsers(receivers, resultList);
        return resultList;
    }

    /**
     *
     * @param receivers
     * @param userList
     */
    private void getUsers(List<String> receivers, List<String> userList) {
        if(receivers != null && receivers.size() > 0) {
            String receiver = "";
            for(int i = 0; i < receivers.size(); i ++) {
                receiver = receivers.get(i);
                if(groupMap.containsKey(receiver)) {
                    List<String> newList = new ArrayList<>(8);
                    if(cacheMap.containsKey(receiver)) {
                        newList.addAll(cacheMap.get(receiver));
                    } else {
                        getUsers(groupMap.get(receiver), newList);
                        cacheMap.put(receiver, newList);
                    }
                    for(int j = 0; j < newList.size(); j ++) {
                        add(userList, newList.get(j));
                    }
                } else {
                    this.add(userList, receiver);
                }
            }
        }
    }

    /**
     *
     * @param list
     * @param receiver
     */
    private void add(List<String> list, String receiver) {
        if(!list.contains(receiver)) {
            list.add(receiver);
        }
    }

    public static void main(String[] args) {
        List<String> receivers = Arrays.asList("g1", "u2", "g2", "u3", "g3", "u7");
        ReceiverExtractor re = new ReceiverExtractor();
        List<String> userList = re.getUsers(receivers);
        ListUtils.print(userList);
    }
}
