package com.universityofruhuna.mmSystem.technologyfaculty.ICTD.service;

import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.dao.FeedbackRepository;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.entity.Feedback;
import com.universityofruhuna.mmSystem.technologyfaculty.ICTD.requestmodel.AddFeedbackRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ClintService {

    private FeedbackRepository feedbackRepository;

    @Autowired
    public ClintService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public void postFeedback(AddFeedbackRequest addFeedbackRequest){

        Feedback feedback = new Feedback();
        feedback.setRole(addFeedbackRequest.getRole());
        feedback.setComponent(addFeedbackRequest.getComponent());
        feedback.setFeedback(addFeedbackRequest.getFeedback());
        feedback.setDate(addFeedbackRequest.getDate());
        feedback.setSignature(feedback.getSignature());
        feedbackRepository.save(feedback);

    }
}
