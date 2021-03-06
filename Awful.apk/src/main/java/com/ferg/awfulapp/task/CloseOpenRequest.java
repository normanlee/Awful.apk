package com.ferg.awfulapp.task;

import android.content.Context;
import android.net.Uri;

import com.ferg.awfulapp.constants.Constants;
import com.ferg.awfulapp.util.AwfulError;

import org.jsoup.nodes.Document;

public class CloseOpenRequest extends AwfulRequest<Void> {
    private int threadId;
    public CloseOpenRequest(Context context, int threadId) {
        super(context, Constants.FUNCTION_POSTINGS);
        this.threadId = threadId;
    }

    @Override
    protected String generateUrl(Uri.Builder urlBuilder) {
        addPostParam(Constants.PARAM_THREAD_ID, Integer.toString(threadId));

        urlBuilder.appendQueryParameter(Constants.PARAM_ACTION, Constants.ACTION_OPEN_CLOSE_THREAD);
        return urlBuilder.build().toString();
    }

    @Override
    protected Void handleResponse(Document doc) throws AwfulError {
        return null;
    }

    @Override
    protected boolean handleError(AwfulError error, Document doc) {
        return error.isCritical();
    }
}
